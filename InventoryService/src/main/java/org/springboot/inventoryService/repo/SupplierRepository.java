package org.springboot.inventoryService.repo;

import java.util.UUID;

import org.springboot.inventoryService.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> 
{

}
