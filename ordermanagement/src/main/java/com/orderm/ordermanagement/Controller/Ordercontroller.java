package com.orderm.ordermanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderm.ordermanagement.Entities.Oorder;
import com.orderm.ordermanagement.Entities.OrderItem;
import com.orderm.ordermanagement.Service.OrderService;

@RestController
@RequestMapping("/orders")
class OrderController 
{
    @Autowired
     OrderService service;
    
     @PostMapping("/{customerId}")
    public Oorder placeOrder(@PathVariable Long customerId, @RequestBody List<OrderItem> orderItems) {
        return service.placeOrder(customerId, orderItems);
    }
    @GetMapping("/report/total-orders")
    public List<Object[]> getTotalOrdersByCustomer() {
        return service.getTotalOrdersByCustomer();
    }
    
    @GetMapping("/report/top-customers")
    public List<Object[]> getTop5Customers() {
        return service.getTop5Customers();
    }
}