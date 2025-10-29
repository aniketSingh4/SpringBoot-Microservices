package org.springboot.productServices.repository;

import org.springboot.productServices.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
