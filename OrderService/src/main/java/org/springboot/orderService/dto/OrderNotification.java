package org.springboot.orderService.dto;

public class OrderNotification 
{
	private String orderId;
    private String itemName;
    private int quantity;
    
    
	public String getOrderId() {
		return orderId;
	}
	public String getItemName() {
		return itemName;
	}
	public int getQuantity() {
		return quantity;
	}
    
    

}
