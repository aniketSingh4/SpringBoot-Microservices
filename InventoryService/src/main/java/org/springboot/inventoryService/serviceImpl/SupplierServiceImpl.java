package org.springboot.inventoryService.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.Supplier;
import org.springboot.inventoryService.repo.SupplierRepository;
import org.springboot.inventoryService.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService
{
	@Autowired
	private SupplierRepository supplierRepo;

	@Override
	public String addSupplier(Supplier supplier) 
	{
		supplierRepo.save(supplier);
		return "Supplier Data Added.";
	}

	@Override
	public Supplier getSupplierById(UUID id) 
	{
		return supplierRepo.findById(id).orElseThrow(()-> new RuntimeException("NO Such Supplier Details find!."));
	}

	@Override
	public List<Supplier> getAllSuppliers() 
	{
		return supplierRepo.findAll();
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) 
	{
		supplierRepo.save(supplier);
		return supplier;
	}

	@Override
	public Supplier updateSupplier(UUID id, Supplier supplier) 
	{
		return supplierRepo.findById(id).map(item->{
			item.setName(supplier.getName());
			item.setAddress(supplier.getAddress());
			item.setContact_info(supplier.getContact_info());
			item.setCreated_at(supplier.getCreated_at());
			item.setRating(supplier.getRating());
			item.setItems(supplier.getItems());
			
			return supplierRepo.save(item);
		}).orElseThrow(()-> new RuntimeException("No Such Supplier Records Founds!."));
	}

	@Override
	public Supplier deleteSupplier(UUID id) 
	{
		Supplier supplier = supplierRepo.findById(id).orElseThrow();
		supplierRepo.delete(supplier);
		return supplier;
	}

	@Override
	public Supplier deleteSupplier(Supplier supplier) 
	{
		supplierRepo.delete(supplier);
		return supplier;
	}

}
