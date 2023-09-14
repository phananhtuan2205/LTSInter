package com.example.intern_BE.Service.imp;

import com.example.intern_BE.Entity.ProductType;
import com.example.intern_BE.Repo.ProductTypeRepository;
import com.example.intern_BE.Service.ProductTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeImp implements ProductTypeInfo {
    @Autowired
    private ProductTypeRepository productTypeRepository;


    @Override
    public List<ProductType> getall() {
        return productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> getbyid(Integer id) {
        return productTypeRepository.findById(id);

    }

}
