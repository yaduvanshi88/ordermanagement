package com.orderm.ordermanagement.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.orderm.ordermanagement.Entities.Customer;
import com.orderm.ordermanagement.Entities.Order;
import com.orderm.ordermanagement.Entities.OrderItem;
import com.orderm.ordermanagement.Entities.Product;
import com.orderm.ordermanagement.Repository.CustomerRepository;
import com.orderm.ordermanagement.Repository.OrderRepository;
import com.orderm.ordermanagement.Repository.ProductRepository;

@Service
 public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }
    
    public Order placeOrder(Long customerId, List<OrderItem> orderItems) 
    {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        BigDecimal totalAmount = BigDecimal.ZERO;
        
        for (OrderItem item : orderItems) {
            Product product = productRepository.findById(item.getProduct().getId()).orElseThrow();
            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
            totalAmount = totalAmount.add(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);
        return orderRepository.save(order);
    }
    public List<Object[]> getTotalOrdersByCustomer() {
        return orderRepository.countOrdersByCustomer();
    }
    
    public List<Object[]> getTop5Customers() {
        return orderRepository.findTop5CustomersWithMostOrders(org.springframework.data.domain.PageRequest.of(0, 5));
    }
}
