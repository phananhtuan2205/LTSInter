package com.example.intern_BE.Repo;

import com.example.intern_BE.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM product  WHERE name_product like :name% and trang_thai=true", nativeQuery = true)
    Page<Product> findAllByNameProduct(@Param("name") String name,Pageable pageable);
    @Query(value = "SELECT * FROM product  WHERE product_type_id =:id", nativeQuery = true)
    Page<Product> findAllByProductTypeId(@Param("id") Integer id, Pageable pageable);

}