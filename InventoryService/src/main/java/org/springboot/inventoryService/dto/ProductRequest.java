package org.springboot.inventoryService.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductRequest 
{
    private String sku;
    private String name;
    private String description;
    private String category;
    private String unit_of_measure;
    private String status;
    private Double cost_prize;
    private Double selling_prize;
    private Integer quantity_in_stock;
    private Integer reorder_level;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private UUID supplier_id;
    private UUID warehouse_id;
    
  
    //Parameterized and Non-Parameterized Constructor
    public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductRequest(String sku, String name, String description, String category, String unit_of_measure,
			String status, Double cost_prize, Double selling_prize, Integer quantity_in_stock, Integer reorder_level,
			LocalDateTime created_at, LocalDateTime updated_at, UUID supplier_id, UUID warehouse_id) {
		super();
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.category = category;
		this.unit_of_measure = unit_of_measure;
		this.status = status;
		this.cost_prize = cost_prize;
		this.selling_prize = selling_prize;
		this.quantity_in_stock = quantity_in_stock;
		this.reorder_level = reorder_level;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.supplier_id = supplier_id;
		this.warehouse_id = warehouse_id;
	}
	
	
	//Getter and Setter Methods
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUnit_of_measure() {
		return unit_of_measure;
	}
	public void setUnit_of_measure(String unit_of_measure) {
		this.unit_of_measure = unit_of_measure;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getCost_prize() {
		return cost_prize;
	}
	public void setCost_prize(Double cost_prize) {
		this.cost_prize = cost_prize;
	}
	public Double getSelling_prize() {
		return selling_prize;
	}
	public void setSelling_prize(Double selling_prize) {
		this.selling_prize = selling_prize;
	}
	public Integer getQuantity_in_stock() {
		return quantity_in_stock;
	}
	public void setQuantity_in_stock(Integer quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}
	public Integer getReorder_level() {
		return reorder_level;
	}
	public void setReorder_level(Integer reorder_level) {
		this.reorder_level = reorder_level;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public UUID getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(UUID supplier_id) {
		this.supplier_id = supplier_id;
	}
	public UUID getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(UUID warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
    
    
}

