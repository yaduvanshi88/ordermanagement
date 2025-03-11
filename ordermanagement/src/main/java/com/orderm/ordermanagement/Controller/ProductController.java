package com.orderm.ordermanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderm.ordermanagement.Entities.Product;
import com.orderm.ordermanagement.Service.ProductService;

@RestController
@RequestMapping("/products")
class ProductController {
    @Autowired
     ProductService service;
    @PostMapping 
    public Product addProduct(@RequestBody Product product) 
    { 
        return service.addProduct(product); 
    }
    @GetMapping 
    public List<Product> getAllProducts() { 
        return service.getAllProducts(); 
    }
}