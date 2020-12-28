package com.psybrainy.eshop.persistence;

import com.psybrainy.eshop.domain.Product;
import com.psybrainy.eshop.persistence.crud.ProductCrudRepository;
import com.psybrainy.eshop.persistence.entity.ProductEntity;
import com.psybrainy.eshop.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.psybrainy.eshop.domain.repository.ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<ProductEntity> products = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    public Optional<Product> getProduct(int productId){
        return productCrudRepository.findById(productId).map(productEntity -> mapper.toProduct(productEntity)) ;
    }

    @Override
    public Optional<List<Product>> getByName(String name){
        List<ProductEntity> products = productCrudRepository.findByName(name);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Product save(Product product){
        ProductEntity productEntity = mapper.toProductEntity(product);
        return mapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }

}
