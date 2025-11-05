package org.springboot.inventoryService.repo;

import java.util.UUID;

import org.springboot.inventoryService.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, UUID>
{

}
