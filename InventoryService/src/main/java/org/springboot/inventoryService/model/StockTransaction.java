package org.springboot.inventoryService.model;

import java.time.LocalDateTime;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stock-Transaction")
public class StockTransaction 
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private InventoryItem item;
	
	private int quantity_change;
	
	private LocalDateTime transaction_date;
	
	private String refId;
	
	private String note;
	
	private String transactionType;
	
	//Parameterized and Non-Parameterized Constructor
	public StockTransaction(UUID id, InventoryItem item, int quantity_change, LocalDateTime transaction_date,
			String refId, String note, String transactionType) 
	{
		super();
		this.id = id;
		this.item = item;
		this.quantity_change = quantity_change;
		this.transaction_date = transaction_date;
		this.refId = refId;
		this.note = note;
		this.transactionType = transactionType;
	}
	

	public StockTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}



	//Getter and Setter Methods;
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public InventoryItem getItem() {
		return item;
	}
	public void setItem(InventoryItem item) {
		this.item = item;
	}
	public int getQuantity_change() {
		return quantity_change;
	}
	public void setQuantity_change(int quantity_change) {
		this.quantity_change = quantity_change;
	}
	public LocalDateTime getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(LocalDateTime transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	@PrePersist
    public void onCreate() 
	{
		transaction_date = LocalDateTime.now();
    }
	

}
