package org.springboot.inventoryService.repo;

import java.util.UUID;

import org.springboot.inventoryService.model.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTransactionRepository extends JpaRepository<StockTransaction, UUID>
{

}
