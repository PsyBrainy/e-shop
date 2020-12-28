package com.psybrainy.eshop.persistence.crud;

import com.psybrainy.eshop.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}
