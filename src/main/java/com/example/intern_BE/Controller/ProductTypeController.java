package com.example.intern_BE.Controller;

import com.example.intern_BE.Entity.ProductType;
import com.example.intern_BE.Service.ProductTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ProductTypeController {
    @Autowired
    private ProductTypeInfo productTypeInfo;

    @GetMapping("/site/categoryall")
    public List<ProductType> productTypeList() {
        return  productTypeInfo.getall();
    }

    @GetMapping("/site/categorybyid")
    public Optional<ProductType> productTypeList(@RequestParam("id") Integer id) {
        return  productTypeInfo.getbyid(id);
    }
}
