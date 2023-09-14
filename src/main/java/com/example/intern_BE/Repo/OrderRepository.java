package com.example.intern_BE.Repo;

import com.example.intern_BE.Entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> getAllBy (Pageable pageable);
    Page<Order> getAllByOrderStatusId (Integer id, Pageable pageable);

}