package com.psybrainy.eshop.web.controller;

import com.psybrainy.eshop.domain.Product;
import com.psybrainy.eshop.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<Product> getAll(){
        return productService.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productService.getProductById(productId);
    }

    public Optional<List<Product>> getByName(String name){
        return productService.getByName(name);
    }

    public Product save(Product product){
        return productService.save(product);
    }

    public boolean delete(int productId){
        return productService.delete(productId);
    }

}
