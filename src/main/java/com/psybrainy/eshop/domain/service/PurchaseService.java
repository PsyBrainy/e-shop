package com.psybrainy.eshop.domain.service;

import com.psybrainy.eshop.domain.Purchase;
import com.psybrainy.eshop.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String cleintId){
        return purchaseRepository.getByClient(cleintId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
