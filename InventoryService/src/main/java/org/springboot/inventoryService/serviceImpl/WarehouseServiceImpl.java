package org.springboot.inventoryService.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.Warehouse;
import org.springboot.inventoryService.repo.WarehouseRepository;
import org.springboot.inventoryService.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService
{
	@Autowired
	private WarehouseRepository repo;

	@Override
	public String addWarehouse(Warehouse warehouse) 
	{
		repo.save(warehouse);
		return "Warehouse Record Added Into DB.";
	}

	@Override
	public Warehouse getWarehouseById(UUID id) 
	{
		return repo.findById(id).orElseThrow(()-> new RuntimeException("No Such Warehouse Find!."));
	}

	@Override
	public List<Warehouse> getAllWarehouse() 
	{
		return repo.findAll();
	}

	@Override
	public Warehouse updateWarehouse(Warehouse warehouse) 
	{
		repo.save(warehouse);
		return warehouse;
	}

	@Override
	public Warehouse updateWarehouse(UUID id, Warehouse warehouse) 
	{
		return repo.findById(id).map(item->
		{
			item.setCapacity(warehouse.getCapacity());
			item.setCreated_at(warehouse.getCreated_at());
			item.setItems(warehouse.getItems());
			item.setLocation(warehouse.getLocation());
			item.setName(warehouse.getName());
			
			return repo.save(item);
		}).orElseThrow();
	}

	@Override
	public Warehouse deleteWarehouse(UUID id) 
	{
		Warehouse warehouse = repo.findById(id).orElseThrow();
		repo.delete(warehouse);
		return warehouse;
	}

	@Override
	public Warehouse deleteWarehouse(Warehouse warehouse) 
	{
		repo.delete(warehouse);
		return warehouse;
	}

}
