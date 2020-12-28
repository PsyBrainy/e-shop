package com.psybrainy.eshop.domain.repository;

import com.psybrainy.eshop.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();
    Optional<List<Product>> getByName(String name);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
