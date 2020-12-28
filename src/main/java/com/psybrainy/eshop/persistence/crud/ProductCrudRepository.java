package com.psybrainy.eshop.persistence.crud;

import com.psybrainy.eshop.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    List<ProductEntity> findByName(String name);
}
