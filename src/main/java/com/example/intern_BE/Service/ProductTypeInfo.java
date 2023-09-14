package com.example.intern_BE.Service;

import com.example.intern_BE.Entity.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeInfo {
    public List<ProductType> getall();
    public Optional<ProductType> getbyid(Integer id);
}
