package org.springboot.inventoryService.controller;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.StockTransaction;
import org.springboot.inventoryService.serviceImpl.StockTransactionServiceImpl;
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
@RequestMapping("/api/transaction")
public class StockTransactionController 
{
	@Autowired
	private StockTransactionServiceImpl transactionImpl;
	
	@GetMapping()
	public List<StockTransaction> getAllTransaction()
	{
		return transactionImpl.getAllStockTransaction();
	}
	
	@GetMapping("/{id}")
	public StockTransaction getTransactionById(@PathVariable UUID id)
	{
		return transactionImpl.getStockTransactionById(id);
	}
	
	@PostMapping()
	public String addTransaction(@RequestBody StockTransaction transaction)
	{
		return transactionImpl.addStockTransaction(transaction);
	}
	
	@PutMapping()
	public StockTransaction updateTransaction(@RequestBody StockTransaction transaction)
	{
		return transactionImpl.updateStockTransaction(transaction);
	}
	
	@PutMapping("/{id}")
	public StockTransaction updateTransaction(@PathVariable UUID id, @RequestBody StockTransaction transaction)
	{
		return transactionImpl.updateStockTransaction(id, transaction);
	}
	
	@DeleteMapping("/{id}")
	public StockTransaction deleteTransaction(@PathVariable UUID id)
	{
		return transactionImpl.deleteStockTransaction(id);
	}
	
	@DeleteMapping()
	public StockTransaction deleteTransaction(@RequestBody StockTransaction transaction)
	{
		return transactionImpl.deleteStockTransaction(transaction);
	}
}
