package com.orderm.ordermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderm.ordermanagement.Entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Long> 
{

}
