package org.springboot.inventoryService.controller;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.InventoryItem;
import org.springboot.inventoryService.serviceImpl.InventoryServiceImpl;
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
@RequestMapping("/api/inventory")
public class InventoryItemController 
{
	@Autowired
	private InventoryServiceImpl inventorySer;
	
	
	@GetMapping()
	public List<InventoryItem> getInventory()
	{
		return inventorySer.getAllInventory();
	}
	
	@GetMapping("/{id}")
	public InventoryItem getInventoryById(@PathVariable UUID id)
	{
		return inventorySer.getInventoryById(id);
	}
	
	@GetMapping("/{skuId}")
	public InventoryItem getInventoryBySkuId(@PathVariable String skuId)
	{
		return inventorySer.getInventoryItemBySKUId(skuId);
	}
	
	@GetMapping("/{name}")
	public InventoryItem getInventoryByName(@PathVariable String name)
	{
		return inventorySer.getInventoryItemByName(name);
	}
	
	@PostMapping()
	public void addInventoryItem(@RequestBody InventoryItem item)
	{
		inventorySer.addInventoryItem(item);
		System.out.println("Inventory Item Added.");
	}
	
	@PutMapping()
	public InventoryItem updateInventoryItem(@RequestBody InventoryItem item)
	{
		return inventorySer.updateInventory(item);
	}
	
	@PutMapping("/{id}")
	public InventoryItem updateInventoryItem(@PathVariable UUID id, @RequestBody InventoryItem item)
	{
		return inventorySer.updateInventoryItem(id, item);
	}
	
	@DeleteMapping("/{id}")
	public InventoryItem deleteInventory(@PathVariable UUID id)
	{
		return inventorySer.deleteInventoryById(id);
	}
	
	@DeleteMapping()
	public InventoryItem deleteInventoryItem(@RequestBody InventoryItem item)
	{
		return inventorySer.deleteInventory(item);
	}
}
