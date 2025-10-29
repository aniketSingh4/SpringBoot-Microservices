package org.springboot.customerServices.service;

import java.util.List;
import org.springboot.customerServices.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerService 
{
	void addCustomer(Customer customer);
	Customer getCustomerById(long id);
	List<Customer> getCustomer();
	Customer updateCustomer(long id, Customer customer);
	String updateCustomer(Customer customer);
	Customer deleteCustomerById(long id);
	Customer deleteCustomer(Customer customer);
	//void callProductAPI(long id);
	

}
