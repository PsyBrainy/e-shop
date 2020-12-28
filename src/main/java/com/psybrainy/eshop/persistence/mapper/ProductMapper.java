package com.psybrainy.eshop.persistence.mapper;

import com.psybrainy.eshop.domain.Product;
import com.psybrainy.eshop.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "status", target = "active")
    })
    Product toProduct(ProductEntity productEntity);
    List<Product> toProducts(List<ProductEntity> productEntities);
    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);



}
