package com.orderm.ordermanagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orderm.ordermanagement.Entities.Product;
import com.orderm.ordermanagement.Repository.ProductRepository;

@Service
 public class ProductService {
    private final ProductRepository repository;
   
    public ProductService(ProductRepository repository) 
    { this.repository = repository; }
    
    public Product addProduct(Product product) 
    { return repository.save(product); }
    
    public List<Product> getAllProducts() 
    { return repository.findAll(); }
}
