package com.example.intern_BE.Service;

import com.example.intern_BE.Entity.Order;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderInfo {
    public Order create(Order order);
    public List<Order> getOrder(Pageable pageable);
    public List<Order> getOrderbystatus(Integer statusid,Pageable pageable);
    public Order getbyid(Integer id);
}
