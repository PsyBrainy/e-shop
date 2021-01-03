package com.psybrainy.eshop.persistence.mapper;

import com.psybrainy.eshop.domain.Purchase;
import com.psybrainy.eshop.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "purchaseId", target = "purchaseId"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "dateTime", target = "dateTime"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "commit", target = "comment"),
            @Mapping(source = "status", target = "state"),
            @Mapping(source = "products", target = "items"),
    })
    Purchase toPurchase(PurchaseEntity purchaseEntity);
    List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntities);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    PurchaseEntity toPurchaseEntity(Purchase purchase);
}
