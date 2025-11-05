package org.springboot.inventoryService.repo;

import java.util.Optional;
import java.util.UUID;

import org.springboot.inventoryService.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryItem, UUID>
{
	public Optional<InventoryItem> findBySku(String sku_id);
	public Optional<InventoryItem> findByName(String name);

}
