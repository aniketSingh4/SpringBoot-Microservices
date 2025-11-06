package org.springboot.inventoryService.controller;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.Warehouse;
import org.springboot.inventoryService.serviceImpl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController 
{
	@Autowired
	private WarehouseServiceImpl service;
	
	@GetMapping()
	public List<Warehouse> getAllWarehouse()
	{
		return service.getAllWarehouse();
	}
	
	@GetMapping("/{id}")
	public Warehouse getWarehouseById(@PathVariable UUID id)
	{
		return service.getWarehouseById(id);
	}
	
	@PostMapping()
	public String addWarehouse(@RequestBody Warehouse house)
	{
		return service.addWarehouse(house);
	}
	
	@PutMapping()
	public Warehouse updateWarehouse(@RequestBody Warehouse house)
	{
		return service.updateWarehouse(house);
	}
	
	@PutMapping("/{id}")
	public Warehouse updateWarehouse(@PathVariable UUID id, @RequestBody Warehouse house)
	{
		return service.updateWarehouse(id, house);
	}
	
	@DeleteMapping()
	public Warehouse deleteWarehouse(@RequestBody Warehouse house)
	{
		return service.deleteWarehouse(house);
	}
	
	@DeleteMapping("/{id}")
	public Warehouse deleteWarehouse(@PathVariable UUID id)
	{
		return service.deleteWarehouse(id);
	}

}
