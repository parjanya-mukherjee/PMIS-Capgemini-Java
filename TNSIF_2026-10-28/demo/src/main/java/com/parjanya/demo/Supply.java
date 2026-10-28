package com.parjanya.demo;

public class Supply {
    private long id;
    private String itemName;
    private int quantity;

    public Supply(long id, String itemName, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }
}