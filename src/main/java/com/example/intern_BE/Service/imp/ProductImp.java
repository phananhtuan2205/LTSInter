package com.example.intern_BE.Service.imp;

import com.example.intern_BE.Entity.Product;
import com.example.intern_BE.Repo.ProductRepository;
import com.example.intern_BE.Service.ProductInfo;
import com.example.intern_BE.Utity.ConvertStringtodate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductImp implements ProductInfo {
    @Autowired
     ProductRepository productRepository;


    @Override
    public List<Product> getAllbypage(Pageable pageable,String name) {
        Page<Product> productPage = productRepository.findAllByNameProduct(name,pageable);
        List<Product> products = new ArrayList<>();

        productPage.forEach(item->{
            if (item.getTrangThai() == true && item.getNameProduct().contains(name)){
                products.add(item);
            }
        });
        return  products;
    }



    @Override
    public Product postProduct(Product product) {
        LocalDateTime localDateTime = LocalDateTime.now();
        product.setCreatedAt(localDateTime);
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        Product product1 = productRepository.findById(id).get();
        LocalDateTime localDateTime = LocalDateTime.now();
        product1.setTrangThai(false);
        product1.setUpdateAt(localDateTime);
        productRepository.save(product1);
    }

    @Override
    public void update(Product product) {
        Product product1 = productRepository.findById(product.getId()).get();
        if (product1 == null){
            return;
        }
        product1 = product;
        LocalDateTime localDateTime = LocalDateTime.now();
        product1.setUpdateAt(localDateTime);
        productRepository.save(product1);
    }

    @Override
    public Product getProduct(Integer id) {
        Product product1 = productRepository.findById(id).get();
        return product1;
    }

    @Override
    public Integer totalProductbyname(String name) {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(item->{
            if (item.getTrangThai()==true && item.getNameProduct().contains(name)){
                products.add(item);
            }
        });
        return products.size();
    }

    @Override
    public Integer totalProductbyCate(Integer cateid) {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(item->{
            if (item.getTrangThai()==true && item.getProductType().getId()==cateid){
                products.add(item);
            }
        });
        return products.size();
    }

    @Override
    public List<Product> getAllbycate(Pageable pageable, Integer id) {
        Page<Product> productPage = productRepository.findAllByProductTypeId(id,pageable);
        System.out.println(productPage);
        List<Product> products = new ArrayList<>();

        productPage.forEach(item->{
            if (item.getTrangThai() == true && item.getProductType().getId()== id){
                products.add(item);
            }
        });
        return  products;
    }

}
