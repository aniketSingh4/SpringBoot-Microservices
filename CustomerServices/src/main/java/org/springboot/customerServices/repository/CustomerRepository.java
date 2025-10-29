package org.springboot.customerServices.repository;

import org.springboot.customerServices.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{

}
