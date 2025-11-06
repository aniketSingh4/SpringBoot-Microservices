package org.springboot.inventoryService.service;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierService 
{
	String addSupplier(Supplier supplier);
	Supplier getSupplierById(UUID id);
	List<Supplier> getAllSuppliers();
	Supplier updateSupplier(Supplier supplier);
	Supplier updateSupplier(UUID id, Supplier supplier);
	Supplier deleteSupplier(UUID id);
	Supplier deleteSupplier(Supplier supplier);

}
