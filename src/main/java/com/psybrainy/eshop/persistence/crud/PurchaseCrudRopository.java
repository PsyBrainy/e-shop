package com.psybrainy.eshop.persistence.crud;

import com.psybrainy.eshop.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRopository extends CrudRepository<PurchaseEntity, Integer> {

    Optional<List<PurchaseEntity>> findByClientId(String clientId);
}
