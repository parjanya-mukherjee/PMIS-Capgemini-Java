package com.parjanya.demo;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplies")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addSupply(
            @RequestBody SupplyInput input) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(supplyService.addSupply(input));
    }

    @GetMapping
    public List<Supply> getAllSupplies() {
        return supplyService.getAllSupplies();
    }
}