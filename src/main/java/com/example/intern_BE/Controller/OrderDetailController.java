package com.example.intern_BE.Controller;

import com.example.intern_BE.Entity.OrderDetail;
import com.example.intern_BE.Service.OrderDetailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class OrderDetailController {
    @Autowired
    private OrderDetailInfo orderDetailInfo;

    @PostMapping("/site/addorderdetail")
    public OrderDetail postdetail(@RequestBody OrderDetail orderDetail){
        return orderDetailInfo.create(orderDetail);
    }

    @GetMapping("/site/show")
    public List<OrderDetail> showall(){
        return orderDetailInfo.show();
    }
    @GetMapping("/admin/showbyorderid")
    public ResponseEntity<List<OrderDetail>> showall(Integer id){
        if (orderDetailInfo.showbyorderid(id) == null){
            return new ResponseEntity<>(orderDetailInfo.showbyorderid(id), HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(orderDetailInfo.showbyorderid(id), HttpStatus.OK);
    }

}
