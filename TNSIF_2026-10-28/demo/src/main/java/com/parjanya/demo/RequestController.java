package com.parjanya.demo;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private final SupplyService supplyService;

    public RequestController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createRequest(
            @RequestBody RequestInput input) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(supplyService.allocate(input));
    }
}