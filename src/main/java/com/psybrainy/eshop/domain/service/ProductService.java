package com.psybrainy.eshop.domain.service;

import com.psybrainy.eshop.domain.Product;
import com.psybrainy.eshop.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByName(String name){
        return productRepository.getByName(name);
    }

    public Optional<Product> getProductById(int productId){
        return productRepository.getProduct(productId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        if (getProductById(productId).isPresent()) {
            return true;
        }else {
            return false;
        }
    }
}
