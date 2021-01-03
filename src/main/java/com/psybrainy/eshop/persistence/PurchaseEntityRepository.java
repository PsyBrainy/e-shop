package com.psybrainy.eshop.persistence;

import com.psybrainy.eshop.domain.Purchase;
import com.psybrainy.eshop.domain.repository.PurchaseRepository;
import com.psybrainy.eshop.persistence.crud.PurchaseCrudRopository;
import com.psybrainy.eshop.persistence.entity.PurchaseEntity;
import com.psybrainy.eshop.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseEntityRepository implements PurchaseRepository {

    @Autowired
    private PurchaseCrudRopository purchaseCrudRopository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<PurchaseEntity>) purchaseCrudRopository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String cleintId) {
        return purchaseCrudRopository.findByClientId(cleintId)
                .map(purchaseEntities -> mapper.toPurchases(purchaseEntities));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = mapper.toPurchaseEntity(purchase);
        purchaseEntity.getProducts().forEach(product -> product.setPurchase(purchaseEntity));

        return mapper.toPurchase(purchaseCrudRopository.save(purchaseEntity));
    }
}
