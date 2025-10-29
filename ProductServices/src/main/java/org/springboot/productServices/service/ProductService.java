package org.springboot.productServices.service;

import java.util.List;

import org.springboot.productServices.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductService 
{
	void addProduct(Product product);
	Product getProductById(Long id);
	List<Product> getAllProduct();
	void updateProduct(Product product);
	
	//update existing data into db
	Product updateProduct(long id, Product product);
	void deleteProduct(Product product);
	void deleteProductById(Long id);

}
