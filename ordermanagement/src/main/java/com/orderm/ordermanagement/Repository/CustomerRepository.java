package com.orderm.ordermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderm.ordermanagement.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> 
{

}
