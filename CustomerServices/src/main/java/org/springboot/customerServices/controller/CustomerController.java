package org.springboot.customerServices.controller;

import java.util.List;

import org.springboot.customerServices.model.Customer;
import org.springboot.customerServices.serviceImpl.CustomerServiceImpl;
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
@RequestMapping("/api/customer")
public class CustomerController 
{
	@Autowired
	private CustomerServiceImpl customerSer;
	
	@GetMapping()
	public List<Customer> getCustomer()
	{
		return customerSer.getCustomer();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerbyId(@PathVariable long id)
	{
		return customerSer.getCustomerById(id);
	}
	
	@PostMapping()
	public String addCustomer(@RequestBody Customer customer)
	{
		customerSer.addCustomer(customer);
		return "Customer Record Inserted.";
	}
	
	@PutMapping()
	public String updateCustomer(@RequestBody Customer customer)
	{
		return customerSer.updateCustomer(customer);
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomerById(@PathVariable long id, @RequestBody Customer customer)
	{
		return customerSer.updateCustomer(id, customer);
	}
	
	@DeleteMapping()
	public Customer deleteCustomer(@RequestBody Customer customer)
	{
		return customerSer.deleteCustomer(customer);
	}
	
	@DeleteMapping("/{id}")
	public Customer deleteCustomerById(@PathVariable long id)
	{
		return customerSer.deleteCustomerById(id);
	}

}

