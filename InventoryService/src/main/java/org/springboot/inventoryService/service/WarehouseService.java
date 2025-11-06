package org.springboot.inventoryService.service;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.Warehouse;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseService 
{
	String addWarehouse(Warehouse warehouse);
	Warehouse getWarehouseById(UUID id);
	List<Warehouse> getAllWarehouse();
	Warehouse updateWarehouse(Warehouse warehouse);
	Warehouse updateWarehouse(UUID id, Warehouse warehouse);
	Warehouse deleteWarehouse(UUID id);
	Warehouse deleteWarehouse(Warehouse warehouse);

}
