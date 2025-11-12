package org.springboot.orderService.model;

import java.io.Serializable;

public class Order implements Serializable 
{
    private String orderId;
    private String itemName;
    private int quantity;

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

