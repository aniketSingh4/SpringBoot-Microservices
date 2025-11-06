package org.springboot.inventoryService.service;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.StockTransaction;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTransactionService 
{
	String addStockTransaction(StockTransaction transaction);
	StockTransaction getStockTransactionById(UUID id);
	List<StockTransaction> getAllStockTransaction();
	StockTransaction updateStockTransaction(StockTransaction transaction);
	StockTransaction updateStockTransaction(UUID id, StockTransaction transaction);
	StockTransaction deleteStockTransaction(UUID id);
	StockTransaction deleteStockTransaction(StockTransaction transaction);

}
