package org.springboot.productServices.controller;

import java.util.List;

import org.springboot.productServices.customerDTO.Customer;
import org.springboot.productServices.feignConfig.CustomerFeignConfig;
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
@RequestMapping("/api/product/customer")
public class ProductCustomerController 
{
	@Autowired
	private CustomerFeignConfig feignCon;

	
	//Calling Customer details from Product
	@GetMapping()
	public List<Customer> getCustomer()
	{
		return feignCon.getCustomer();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable long id)
	{
		return feignCon.getCustomerbyId(id);
	}
	
	@PostMapping()
	public String addCustomer(@RequestBody Customer customer)
	{
		return feignCon.addCustomer(customer);
	}
	
	@PutMapping()
	public String updateCustomer(@RequestBody Customer customer)
	{
		return feignCon.updateCustomer(customer);
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer)
	{
		return feignCon.updateCustomerById(id, customer);
	}
	
	@DeleteMapping()
	public Customer deleteCustomer(@RequestBody Customer customer)
	{
		return feignCon.deleteCustomer(customer);
	}
	
	@DeleteMapping("/{id}")
	public Customer deleteCustomer(@PathVariable long id)
	{
		return feignCon.deleteCustomerById(id);
	}
	
	

}
