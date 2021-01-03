package com.psybrainy.eshop.persistence.mapper;

import com.psybrainy.eshop.domain.Product;
import com.psybrainy.eshop.persistence.entity.ProductEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-03T16:28:22-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9.1 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        if ( productEntity.getProductId() != null ) {
            product.setProductId( productEntity.getProductId() );
        }
        product.setName( productEntity.getName() );
        if ( productEntity.getPrice() != null ) {
            product.setPrice( productEntity.getPrice().doubleValue() );
        }
        if ( productEntity.getStock() != null ) {
            product.setStock( productEntity.getStock() );
        }
        if ( productEntity.getStatus() != null ) {
            product.setActive( productEntity.getStatus() );
        }

        return product;
    }

    @Override
    public List<Product> toProducts(List<ProductEntity> productEntities) {
        if ( productEntities == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productEntities.size() );
        for ( ProductEntity productEntity : productEntities ) {
            list.add( toProduct( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductEntity toProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductId( product.getProductId() );
        productEntity.setName( product.getName() );
        productEntity.setPrice( BigDecimal.valueOf( product.getPrice() ) );
        productEntity.setStock( product.getStock() );
        productEntity.setStatus( product.isActive() );

        return productEntity;
    }
}
