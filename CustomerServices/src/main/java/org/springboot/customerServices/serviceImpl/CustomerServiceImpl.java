package org.springboot.customerServices.serviceImpl;
import java.util.List;

import org.springboot.customerServices.model.Customer;
import org.springboot.customerServices.repository.CustomerRepository;
import org.springboot.customerServices.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public void addCustomer(Customer customer) 
	{
		customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerById(long id) 
	{
		return customerRepo.findById(id).orElseThrow(()-> new RuntimeException("No Such Customer Found!."));
	}

	@Override
	public List<Customer> getCustomer() 
	{
		return customerRepo.findAll();
	}

	@Override
	public Customer updateCustomer(long id, Customer customer) 
	{
		return customerRepo.findById(id).map(item->
		{
			item.setName(customer.getName());
			item.setEmail(customer.getEmail());
			item.setAddress(customer.getAddress());
			item.setMobileNo(customer.getMobileNo());
			
			return customerRepo.save(item);
		}).orElseThrow(()-> new RuntimeException("No Such Record Exist with ID: " + id));
	}

	@Override
	public String updateCustomer(Customer customer) 
	{
		customerRepo.save(customer);
		return "Customer Details Updated.";
	}

	@Override
	public Customer deleteCustomerById(long id) 
	{
		Customer cust = customerRepo.findById(id).orElseThrow();
		customerRepo.delete(cust);
		return cust;
	}

	@Override
	public Customer deleteCustomer(Customer customer) 
	{
		customerRepo.delete(customer);
		return customer;
	}

	

}
