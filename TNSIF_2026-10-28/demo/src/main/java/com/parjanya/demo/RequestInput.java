package com.parjanya.demo;

public record RequestInput(
        String itemName,
        int quantity,
        String requestedBy
) {
}