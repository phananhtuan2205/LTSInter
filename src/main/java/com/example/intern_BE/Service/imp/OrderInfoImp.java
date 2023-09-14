package com.example.intern_BE.Service.imp;

import com.example.intern_BE.Entity.Order;
import com.example.intern_BE.Repo.OrderRepository;
import com.example.intern_BE.Repo.OrderStatusRepository;
import com.example.intern_BE.Repo.PaymentRepository;
import com.example.intern_BE.Service.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderInfoImp implements OrderInfo {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Override
    public Order create(Order order) {

        if (order==null || order.getEmail()==null || order.getFullName()==null || order.getAddress()==null){
            return null;
        }
        LocalDateTime dateTime = LocalDateTime.now();
        if (order.getPayment() == null){
            order.setPayment(paymentRepository.findById(1).get());
        }
        if (order.getOrderStatus() == null){
            order.setOrderStatus(orderStatusRepository.findById(1).get());
        }

        order.setCreatedAt(dateTime);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrder(Pageable pageable){
        List<Order> orders = new ArrayList<>();
        orderRepository.getAllBy(pageable).forEach(item->{
            orders.add(item);
        });
        return orders;
    }

    @Override
    public List<Order> getOrderbystatus(Integer statusid, Pageable pageable) {
        if (statusid == 0 || statusid == null){
            return null;
        }
        List<Order> orders = new ArrayList<>();
        orderRepository.getAllByOrderStatusId(statusid,pageable).forEach(item->{
            orders.add(item);
        });
        return orders;
    }

    @Override
    public Order getbyid(Integer id) {
        if (id == 0 || id == null){
            return  null;
        }
        return orderRepository.findById(id).get();
    }
}
