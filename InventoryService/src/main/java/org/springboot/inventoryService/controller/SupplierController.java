package org.springboot.inventoryService.controller;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.Supplier;
import org.springboot.inventoryService.serviceImpl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController 
{
	@Autowired
	private SupplierServiceImpl serviceImpl;
	
	@GetMapping()
	public List<Supplier> getAllSupplier()
	{
		return serviceImpl.getAllSuppliers();
	}
	
	@GetMapping("/{id}")
	public Supplier getSupplierById(@PathVariable UUID id)
	{
		return serviceImpl.getSupplierById(id);
	}
	
	@PostMapping()
	public String addSupplier(@RequestBody Supplier supplier)
	{
		return serviceImpl.addSupplier(supplier);
	}
	
	@PutMapping("/{id}")
	public Supplier updateSupplier(@PathVariable UUID id, @RequestBody Supplier supplier)
	{
		return serviceImpl.updateSupplier(id, supplier);
	}
	
	@PutMapping()
	public Supplier updateSupplier(@RequestBody Supplier supplier)
	{
		return serviceImpl.updateSupplier(supplier);
	}
	
	@DeleteMapping()
	public Supplier deleteSupplier(@RequestBody Supplier supplier)
	{
		return serviceImpl.deleteSupplier(supplier);
	}
	
	@DeleteMapping("/{id}")
	public Supplier deleteSupplier(@PathVariable UUID id)
	{
		return serviceImpl.deleteSupplier(id);
	}

}
