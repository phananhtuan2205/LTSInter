package com.example.intern_BE.Controller;


import com.example.intern_BE.Entity.Product;
import com.example.intern_BE.Repo.ProductRepository;
import com.example.intern_BE.Service.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
public class ProductController {
    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    private ProductInfo productInfo;

    @GetMapping("/site/productall")
    public List<Product> getProduct(@RequestParam("page") Optional<Integer> page , @RequestParam("size") Optional<Integer>  size,@RequestParam("name") String name){
        Sort sort = Sort.by(Sort.Direction.ASC, "product_id");
        Pageable pageable = PageRequest.of(page.orElse(1)-1 , size.orElse(6),sort);
        return  productInfo.getAllbypage(pageable,name);
    }

        @GetMapping("/site/totalproduct")
    public Integer getTotalProduct(@RequestParam("name") String name){
        return productInfo.totalProductbyname(name);
    }
        @GetMapping("/site/totalproductbycate")
    public Integer getTotalProductbycate(@RequestParam("cateid") Integer id){
        return productInfo.totalProductbyCate(id);
    }


    @GetMapping("/site/product")
    public Product getProduct(@RequestParam("id") Integer id){
        return productInfo.getProduct(id);
    }

    @PostMapping("/admin/Product/post")
    public Product postProduct (@RequestBody Product product){
        try {
            System.out.println(product.getProductType().getId());
            return productInfo.postProduct(product);

        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @GetMapping("/site/productbycate")
    public List<Product> listproductbycate(@RequestParam("cateid") Integer id,@RequestParam("page") Optional<Integer> page , @RequestParam("size") Optional<Integer>  size){
        Sort sort = Sort.by(Sort.Direction.ASC, "product_id");
        Pageable pageable = PageRequest.of(page.orElse(1)-1 , size.orElse(9),sort);
        return  productInfo.getAllbycate(pageable,id);
    }

    @PutMapping("/admin/Product/delete")
    public String deleteProduct (@RequestParam("id") Integer id){
        try {

            productInfo.delete(id);
            return "Success";
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @PutMapping("/admin/Product/update")
    public String updateProduct (@RequestBody Product product){
        try {

            productInfo.update(product);
            return "Success";
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
