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
@Table(name = "Warehouse")
public class Warehouse 
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String name;
	
	private String location;
	
	private int capacity;
	
	private LocalDateTime created_at;
	
	
	@OneToMany(mappedBy = "warehouse")
    private List<InventoryItem> items;

    @PrePersist
    public void onCreate() 
    {
        created_at = LocalDateTime.now();
    }
    
    //Parameterized and Non-Parameterized Constructor
    public Warehouse(UUID id, String name, String location, int capacity, LocalDateTime created_at,
			List<InventoryItem> items) 
    {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
		this.created_at = created_at;
		this.items = items;
	}

    public Warehouse() {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
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
