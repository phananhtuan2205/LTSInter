package com.example.intern_BE.Controller;

import com.example.intern_BE.Entity.Account;
import com.example.intern_BE.Entity.Order;
import com.example.intern_BE.Service.OrderInfo;
import com.example.intern_BE.Service.imp.OrderInfoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderInfo orderInfoImp;

    @PostMapping("/site/checkout")
    public Order checkout (@RequestBody Order order){

        return orderInfoImp.create(order);
    }

    @GetMapping("/site/getoder")
    public List<Order> getlist(@RequestParam("page") Optional<Integer> page , @RequestParam("size") Optional<Integer>  size){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page.orElse(1)-1 , size.orElse(6),sort);
        return  orderInfoImp.getOrder(pageable)  ;
    }

    @GetMapping("/site/getoderbystatus")
    public ResponseEntity<List<Order>> getlistbystatus(@RequestParam("page") Optional<Integer> page , @RequestParam("size") Optional<Integer>  size, @RequestParam("statusid") Integer  statusid){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page.orElse(1)-1 , size.orElse(6),sort);
        if (orderInfoImp.getOrderbystatus(statusid,pageable) == null){
            return  new ResponseEntity<>(orderInfoImp.getOrderbystatus(statusid,pageable), HttpStatus.valueOf(404));
        }
        return  new ResponseEntity<>(orderInfoImp.getOrderbystatus(statusid,pageable), HttpStatus.OK);
    }

    @GetMapping("/site/getbyid")
    public ResponseEntity<Order> getlistbystatus( @RequestParam("id") Integer  id){
        if (orderInfoImp.getbyid(id) == null){
            return  new ResponseEntity<>(orderInfoImp.getbyid(id), HttpStatus.valueOf(404));
        }
        return  new ResponseEntity<>(orderInfoImp.getbyid(id), HttpStatus.OK);
    }
}
