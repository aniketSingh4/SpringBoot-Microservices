package org.springboot.inventoryService.service;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.InventoryItem;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryService 
{
	public void addInventoryItem(InventoryItem item);
	public InventoryItem getInventoryById(UUID id);
	public InventoryItem getInventoryItemBySKUId(String sku_id);
	public InventoryItem getInventoryItemByName(String name);
	public List<InventoryItem> getAllInventory();
	public InventoryItem updateInventoryItem(UUID id, InventoryItem item);
	public InventoryItem updateInventory(InventoryItem item);
	public InventoryItem deleteInventoryById(UUID id);
	public InventoryItem deleteInventory(InventoryItem item);

}
