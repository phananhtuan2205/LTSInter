package com.example.intern_BE.Service;

import com.example.intern_BE.Entity.Order;
import com.example.intern_BE.Entity.Product;
import com.example.intern_BE.Entity.User;
import com.example.intern_BE.Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ProductInfo {
   public List<Product> getAllbypage(Pageable pageable,String name);
   public Product postProduct(Product product);
   public void delete(Integer id);
   public void update(Product product);
   public Product getProduct(Integer id);
   public Integer totalProductbyname(String name);
   public Integer totalProductbyCate(Integer cateid);
   public  List<Product> getAllbycate (Pageable pageable,Integer id);
}
