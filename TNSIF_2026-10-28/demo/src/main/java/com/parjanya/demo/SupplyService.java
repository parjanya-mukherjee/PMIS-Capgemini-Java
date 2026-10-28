package com.parjanya.demo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final RequestRepository requestRepository;

    public SupplyService(
            SupplyRepository supplyRepository,
            RequestRepository requestRepository) {
        this.supplyRepository = supplyRepository;
        this.requestRepository = requestRepository;
    }

    @Transactional
    public Map<String, Object> addSupply(SupplyInput input) {
        if (input == null
                || input.itemName() == null
                || input.itemName().isBlank()
                || input.quantity() <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Provide an item name and a positive quantity"
            );
        }

        String itemName = input.itemName().trim();

        Supply existing =
            supplyRepository.findByNameForUpdate(itemName);

        int totalQuantity;

        if (existing == null) {
            supplyRepository.insert(itemName, input.quantity());
            totalQuantity = input.quantity();
        } else {
            totalQuantity = existing.getQuantity() + input.quantity();

            supplyRepository.updateQuantity(
                existing.getId(), totalQuantity
            );
        }

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("itemName", itemName);
        result.put("addedQuantity", input.quantity());
        result.put("totalQuantity", totalQuantity);
        result.put("message", "Inventory updated successfully");

        return result;
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    @Transactional
    public Map<String, Object> allocate(RequestInput input) {
        if (input == null
                || input.itemName() == null
                || input.itemName().isBlank()
                || input.requestedBy() == null
                || input.requestedBy().isBlank()
                || input.quantity() <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Provide itemName, a positive quantity, and requestedBy"
            );
        }

        String itemName = input.itemName().trim();
        String requestedBy = input.requestedBy().trim();

        // Lock the matching inventory row within this transaction.
        Supply supply =
            supplyRepository.findByNameForUpdate(itemName);

        if (supply == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Supply item not found: " + itemName
            );
        }

        if (supply.getQuantity() < input.quantity()) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Insufficient stock. Available quantity: "
                    + supply.getQuantity()
            );
        }

        int remaining = supply.getQuantity() - input.quantity();

        // Both SQL operations belong to the same transaction.
        supplyRepository.updateQuantity(supply.getId(), remaining);

        requestRepository.save(
            supply.getItemName(),
            input.quantity(),
            "APPROVED",
            requestedBy
        );

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("itemName", supply.getItemName());
        result.put("quantityAllocated", input.quantity());
        result.put("requestedBy", requestedBy);
        result.put("status", "APPROVED");
        result.put("remainingQuantity", remaining);

        return result;
    }
}