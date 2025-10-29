package org.springboot.customerServices.controller;

import java.util.List;

import org.springboot.customerServices.feignConfig.ProductFeignConfig;
import org.springboot.customerServices.productDTO.Product;
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
@RequestMapping("/api/customer/product")
public class CustomerProductController 
{
	@Autowired
	private ProductFeignConfig feignCon;
	
	@GetMapping()
	public List<Product> getProduct()
	{
		return feignCon.getAllProduct();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable long id)
	{
		return feignCon.getProductById(id);
	}
	
	@PostMapping()
	public String addProduct(@RequestBody Product product)
	{
		return feignCon.addProductIntoDB(product);
	}
	
	@PutMapping()
	public String updateProduct(@RequestBody Product product)
	{
		return feignCon.updateProductIntoDB(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable long id, @RequestBody Product product)
	{
		return feignCon.updateProductIntoDB(id, product);
	}
	
	@DeleteMapping()
	public String deleteProduct(@RequestBody Product product)
	{
		return feignCon.deleteProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable long id)
	{
		return feignCon.deleteProductById(id);
	}

}
