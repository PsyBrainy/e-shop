package com.psybrainy.eshop.domain.repository;

import com.psybrainy.eshop.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String cleintId);
    Purchase save(Purchase purchase);
}
