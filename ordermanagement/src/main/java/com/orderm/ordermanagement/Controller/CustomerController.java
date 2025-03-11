package com.orderm.ordermanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderm.ordermanagement.Entities.Customer;
import com.orderm.ordermanagement.Service.CustomerService;

@RestController
@RequestMapping("/customers")
class CustomerController {
    @Autowired
     CustomerService service;
    
    @PostMapping 
    public Customer addCustomer(@RequestBody Customer customer) 
    { 
        return service.addCustomer(customer); 
    }
    @GetMapping 
    public List<Customer> getAllCustomers() 
    { 
        return service.getAllCustomers(); 
    }
}
