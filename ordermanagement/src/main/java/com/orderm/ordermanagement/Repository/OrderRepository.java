package com.orderm.ordermanagement.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.orderm.ordermanagement.Entities.Oorder;

public interface OrderRepository extends  JpaRepository<Oorder, Long>  
{
        @Query("SELECT o.customer.id,o.customer.name, COUNT(o) FROM Oorder o GROUP BY o.customer.id")
    List<Object[]> countOrdersByCustomer();
    
    @Query("SELECT o.customer, COUNT(o) FROM Oorder o GROUP BY o.customer ORDER BY COUNT(o) DESC")
    List<Object[]> findTop5CustomersWithMostOrders(org.springframework.data.domain.Pageable pageable);

}
