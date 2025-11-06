package org.springboot.inventoryService.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springboot.inventoryService.model.StockTransaction;
import org.springboot.inventoryService.repo.StockTransactionRepository;
import org.springboot.inventoryService.service.StockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockTransactionServiceImpl implements StockTransactionService
{
	@Autowired
	private StockTransactionRepository repo;

	@Override
	public String addStockTransaction(StockTransaction transaction) 
	{
		repo.save(transaction);
		return "Stock Transaction Details Added.";
	}

	@Override
	public StockTransaction getStockTransactionById(UUID id) 
	{
		return repo.findById(id).orElseThrow(()-> new RuntimeException("NO Such transaction Available!."));
	}

	@Override
	public List<StockTransaction> getAllStockTransaction() 
	{
		return repo.findAll();
	}

	@Override
	public StockTransaction updateStockTransaction(StockTransaction transaction) 
	{
		repo.save(transaction);
		return transaction;
	}

	@Override
	public StockTransaction updateStockTransaction(UUID id, StockTransaction transaction) 
	{
		return repo.findById(id).map(item->
		{
			item.setItem(transaction.getItem());
			item.setNote(transaction.getNote());
			item.setQuantity_change(transaction.getQuantity_change());
			item.setRefId(transaction.getRefId());
			item.setTransaction_date(transaction.getTransaction_date());
			item.setTransactionType(transaction.getTransactionType());
			
			return repo.save(item);
		}).orElseThrow(()-> new RuntimeException("No Such Transaction Available."));
	}

	@Override
	public StockTransaction deleteStockTransaction(UUID id) 
	{
		StockTransaction transaction = repo.findById(id).orElseThrow();
		repo.delete(transaction);
		return transaction;
	}

	@Override
	public StockTransaction deleteStockTransaction(StockTransaction transaction) 
	{
		repo.delete(transaction);
		return transaction;
	}

}
