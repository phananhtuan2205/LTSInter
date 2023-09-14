package com.example.intern_BE.Service.imp;

import com.example.intern_BE.Entity.OrderDetail;
import com.example.intern_BE.Repo.OrderDetailRepository;
import com.example.intern_BE.Repo.OrderRepository;
import com.example.intern_BE.Service.OrderDetailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderDetailImp implements OrderDetailInfo {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        LocalDateTime localDateTime = LocalDateTime.now();
        orderDetail.setCreatedAt(localDateTime);
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> show() {
        return orderDetailRepository.findAll();
    }

    @Override
    public List<OrderDetail> showbyorderid(Integer id) {
        if (id == null){
            return  null;
        }
        return orderDetailRepository.findAllByOrderId(id);
    }


}
