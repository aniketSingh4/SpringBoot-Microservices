package org.springboot.inventoryService.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "Inventory")
public class InventoryItem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(unique = true, nullable = false)
	private String sku;
	
	private String name;
	
	private String description;
	
	private String category;
	
	private String unit_of_measure;
	
	private double cost_prize;
	
	private double selling_prize;
	
	private int quantity_in_stock;
	
	private int reorder_level;
	
	private LocalDateTime created_at;
	
	private LocalDateTime updated_at;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
    private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouse;
	
	
	//Parameterized Constructor and Non-Parameterized Constructor
	public InventoryItem(UUID id, String sku, String name, String description, String category, String unit_of_measure,
			double cost_prize, double selling_prize, int quantity_in_stock, int reorder_level, LocalDateTime created_at,
			LocalDateTime updated_at, String status, Supplier supplier, Warehouse warehouse) 
	{
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.category = category;
		this.unit_of_measure = unit_of_measure;
		this.cost_prize = cost_prize;
		this.selling_prize = selling_prize;
		this.quantity_in_stock = quantity_in_stock;
		this.reorder_level = reorder_level;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.status = status;
		this.supplier = supplier;
		this.warehouse = warehouse;
	}
	
	
	
	public InventoryItem() {
		super();
		// TODO Auto-generated constructor stub
	}



	//Generate Getter and Setter
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
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
	public double getCost_prize() {
		return cost_prize;
	}
	public void setCost_prize(double cost_prize) {
		this.cost_prize = cost_prize;
	}
	public double getSelling_prize() {
		return selling_prize;
	}
	public void setSelling_prize(double selling_prize) {
		this.selling_prize = selling_prize;
	}
	public int getQuantity_in_stock() {
		return quantity_in_stock;
	}
	public void setQuantity_in_stock(int quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}
	public int getReorder_level() {
		return reorder_level;
	}
	public void setReorder_level(int reorder_level) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



	public Supplier getSupplier() {
		return supplier;
	}



	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}



	public Warehouse getWarehouse() {
		return warehouse;
	}



	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	// Constructors, Getters, Setters
    @PrePersist
    public void onCreate() 
    {
        created_at = LocalDateTime.now();
        updated_at = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() 
    {
        updated_at = LocalDateTime.now();
    }
	
	
}
