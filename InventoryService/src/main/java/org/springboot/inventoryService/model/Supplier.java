package org.springboot.inventoryService.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier 
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	
	private String contact_info;
	
	private String address;
	
	private int rating;
	
	private LocalDateTime created_at;
	
	@OneToMany(mappedBy = "supplier")
    private List<InventoryItem> items;

    @PrePersist
    public void onCreate() 
    {
        created_at = LocalDateTime.now();
    }
    
    //Parameterized and Non-Parameterized Constructor
    public Supplier(UUID id, String name, String contact_info, String address, int rating, LocalDateTime created_at,
			List<InventoryItem> items) 
    {
		super();
		this.id = id;
		this.name = name;
		this.contact_info = contact_info;
		this.address = address;
		this.rating = rating;
		this.created_at = created_at;
		this.items = items;
	}
  
    public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getter and Setter Methods
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public List<InventoryItem> getItems() {
		return items;
	}

	public void setItems(List<InventoryItem> items) {
		this.items = items;
	}
}
