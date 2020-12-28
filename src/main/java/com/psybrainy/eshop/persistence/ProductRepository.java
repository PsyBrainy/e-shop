package com.psybrainy.eshop.persistence;

import com.psybrainy.eshop.persistence.crud.ProductCrudRepository;
import com.psybrainy.eshop.persistence.entity.ProductEntity;

import java.util.List;

public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<ProductEntity> getAll(){
        return (List<ProductEntity>) productCrudRepository.findAll();
    }
    
}
