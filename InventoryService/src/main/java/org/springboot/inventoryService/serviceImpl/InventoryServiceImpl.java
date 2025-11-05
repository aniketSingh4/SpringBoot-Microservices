package org.springboot.inventoryService.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.InventoryItem;
import org.springboot.inventoryService.repo.InventoryRepository;
import org.springboot.inventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService
{
	@Autowired
	private InventoryRepository inventoryRepo;

	@Override
	public void addInventoryItem(InventoryItem item) 
	{
		inventoryRepo.save(item);
		
	}

	@Override
	public InventoryItem getInventoryItemBySKUId(String sku_id) 
	{
		return inventoryRepo.findBySku(sku_id).orElseThrow();
	}

	@Override
	public InventoryItem getInventoryItemByName(String name) 
	{
		return inventoryRepo.findByName(name).orElseThrow();
	}

	@Override
	public InventoryItem updateInventoryItem(UUID id, InventoryItem item) 
	{
		return inventoryRepo.findById(id).map(item1->
		{
			item1.setSku(item.getSku());
			item1.setName(item.getName());
			item1.setDescription(item.getDescription());
			item1.setCategory(item.getCategory());
			item1.setCost_prize(item.getCost_prize());
			item1.setCreated_at(item.getCreated_at());
			item1.setQuantity_in_stock(item.getQuantity_in_stock());
			item1.setReorder_level(item.getReorder_level());
			item1.setSelling_prize(item.getSelling_prize());
			item1.setUnit_of_measure(item.getUnit_of_measure());
			item1.setUpdated_at(item.getUpdated_at());
			item1.setStatus(item.getStatus());
			
			return inventoryRepo.save(item1);	
		}).orElseThrow(()-> new RuntimeException("No Such Record Exist with ID: " + id));
	}

	@Override
	public InventoryItem updateInventory(InventoryItem item) 
	{
		inventoryRepo.save(item);
		return item;
	}

	@Override
	public InventoryItem deleteInventoryById(UUID id) 
	{
		InventoryItem item = inventoryRepo.findById(id).orElseThrow();
		inventoryRepo.delete(item);
		return item;
	}

	@Override
	public InventoryItem deleteInventory(InventoryItem item) 
	{
		inventoryRepo.delete(item);
		return item;
	}

	@Override
	public InventoryItem getInventoryById(UUID id) 
	{
		return inventoryRepo.findById(id).orElseThrow(()-> new RuntimeException("No such Item Available."));
	}

	@Override
	public List<InventoryItem> getAllInventory() 
	{
		return inventoryRepo.findAll();
	}
	

}
