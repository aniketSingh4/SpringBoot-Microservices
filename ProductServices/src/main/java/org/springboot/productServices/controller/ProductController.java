package org.springboot.productServices.controller;

import java.util.List;

import org.springboot.productServices.model.Product;
import org.springboot.productServices.serviceImpl.ProductServiceImpl;
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
@RequestMapping("/api/product")
public class ProductController 
{
		@Autowired
		private ProductServiceImpl productSer;
		
		
		//All Product Related Mappings
		@GetMapping("/{id}")
		Product getProductById(@PathVariable long id)
		{
			return productSer.getProductById(id);
		}
		
		@GetMapping()
		List<Product> getAllProduct()
		{
			return productSer.getAllProduct();
		}
		
		@PostMapping()
		String addProductIntoDB(@RequestBody Product product)
		{
			productSer.addProduct(product);
			return "Product DATA Added.";
		}
		
		@PutMapping()
		String updateProductIntoDB(@RequestBody Product product)
		{
			productSer.updateProduct(product);
			//productSer.addProduct(product);
			return "Product Data Updated.";
		}
		
		@PutMapping("/{id}")
		Product updateProductIntoDB(@PathVariable long id, @RequestBody Product product)
		{
			return productSer.updateProduct(id, product);
		}
		
		@DeleteMapping("/{id}")
		String deleteProductById(@PathVariable long id)
		{
			productSer.deleteProductById(id);
			return "Product Data Deleted By Id.";
		}
		
		@DeleteMapping()
		String deleteProduct(@RequestBody Product product)
		{
			productSer.deleteProduct(product);
			return "Product Data Deleted.";
		}

}
