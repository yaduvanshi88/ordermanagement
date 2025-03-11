package com.orderm.ordermanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.orderm.ordermanagement.Entities.Customer;
import com.orderm.ordermanagement.Repository.CustomerRepository;

@Service
 public class CustomerService {
    private final CustomerRepository repository;
    public CustomerService(CustomerRepository repository) { this.repository = repository; }
    public Customer addCustomer(Customer customer) { return repository.save(customer); }
    public List<Customer> getAllCustomers() { return repository.findAll(); }
    public Optional<Customer> getCustomerById(Long id) { return repository.findById(id); }
}