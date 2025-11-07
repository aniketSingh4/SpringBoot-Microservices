package org.springboot.inventoryService.service;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.dto.ProductRequest;
import org.springboot.inventoryService.model.InventoryItem;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryService 
{
	//public String addInventoryItem(InventoryItem item);
	public String addProductInventoryItem(ProductRequest product);
	public InventoryItem getInventoryById(UUID id);
	public InventoryItem getInventoryItemBySKUId(String sku_id);
	public InventoryItem getInventoryItemByName(String name);
	public List<InventoryItem> getAllInventory();
	public InventoryItem updateInventoryItem(UUID id, ProductRequest item);
	public InventoryItem updateInventory(ProductRequest item);
	public InventoryItem deleteInventoryById(UUID id);
	public InventoryItem deleteInventory(ProductRequest item);

}
