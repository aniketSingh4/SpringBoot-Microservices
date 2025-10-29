package org.springboot.customerServices.feignConfig;

import java.util.List;

import org.springboot.customerServices.productDTO.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PRODUCTSERVICE")
public interface ProductFeignConfig 
{
	@GetMapping("/{id}")
	Product getProductById(@PathVariable long id);
	
	@GetMapping()
	List<Product> getAllProduct();
	
	@PostMapping()
	String addProductIntoDB(@RequestBody Product product);
	
	@PutMapping()
	String updateProductIntoDB(@RequestBody Product product);
	
	@PutMapping("/{id}")
	Product updateProductIntoDB(@PathVariable long id, @RequestBody Product product);
	
	
	@DeleteMapping("/{id}")
	String deleteProductById(@PathVariable long id);
	
	@DeleteMapping()
	String deleteProduct(@RequestBody Product product);

}
