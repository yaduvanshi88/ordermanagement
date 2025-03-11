package com.orderm.ordermanagement.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.orderm.ordermanagement.Entities.Order;

public interface OrderRepository extends  JpaRepository<Order, Long>  
{
        @Query("SELECT o.customer.id, COUNT(o) FROM Order o GROUP BY o.customer.id")
    List<Object[]> countOrdersByCustomer();
    
    @Query("SELECT o.customer, COUNT(o) FROM Order o GROUP BY o.customer ORDER BY COUNT(o) DESC")
    List<Object[]> findTop5CustomersWithMostOrders(org.springframework.data.domain.Pageable pageable);

}
