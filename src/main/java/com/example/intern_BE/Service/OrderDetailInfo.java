package com.example.intern_BE.Service;

import com.example.intern_BE.Entity.Order;
import com.example.intern_BE.Entity.OrderDetail;

import java.util.List;

public interface OrderDetailInfo {
    public OrderDetail create(OrderDetail orderDetail);
    public List<OrderDetail> show();
    public List<OrderDetail> showbyorderid(Integer id);
}
