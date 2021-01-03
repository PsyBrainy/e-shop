package com.psybrainy.eshop.persistence.mapper;

import com.psybrainy.eshop.domain.Purchase;
import com.psybrainy.eshop.domain.PurchaseItem;
import com.psybrainy.eshop.persistence.entity.PurchaseEntity;
import com.psybrainy.eshop.persistence.entity.PurchaseProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-03T16:28:21-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9.1 (Amazon.com Inc.)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Autowired
    private PurchaseItemMapper purchaseItemMapper;

    @Override
    public Purchase toPurchase(PurchaseEntity purchaseEntity) {
        if ( purchaseEntity == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        if ( purchaseEntity.getPurchaseId() != null ) {
            purchase.setPurchaseId( purchaseEntity.getPurchaseId() );
        }
        purchase.setClientId( purchaseEntity.getClientId() );
        purchase.setDateTime( purchaseEntity.getDateTime() );
        purchase.setPaymentMethod( purchaseEntity.getPaymentMethod() );
        purchase.setComment( purchaseEntity.getCommit() );
        purchase.setState( purchaseEntity.getStatus() );
        purchase.setItems( purchaseProductEntityListToPurchaseItemList( purchaseEntity.getProducts() ) );

        return purchase;
    }

    @Override
    public List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntities) {
        if ( purchaseEntities == null ) {
            return null;
        }

        List<Purchase> list = new ArrayList<Purchase>( purchaseEntities.size() );
        for ( PurchaseEntity purchaseEntity : purchaseEntities ) {
            list.add( toPurchase( purchaseEntity ) );
        }

        return list;
    }

    @Override
    public PurchaseEntity toPurchaseEntity(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        PurchaseEntity purchaseEntity = new PurchaseEntity();

        purchaseEntity.setPurchaseId( purchase.getPurchaseId() );
        purchaseEntity.setClientId( purchase.getClientId() );
        purchaseEntity.setDateTime( purchase.getDateTime() );
        purchaseEntity.setPaymentMethod( purchase.getPaymentMethod() );
        purchaseEntity.setCommit( purchase.getComment() );
        purchaseEntity.setStatus( purchase.getState() );
        purchaseEntity.setProducts( purchaseItemListToPurchaseProductEntityList( purchase.getItems() ) );

        return purchaseEntity;
    }

    protected List<PurchaseItem> purchaseProductEntityListToPurchaseItemList(List<PurchaseProductEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItem> list1 = new ArrayList<PurchaseItem>( list.size() );
        for ( PurchaseProductEntity purchaseProductEntity : list ) {
            list1.add( purchaseItemMapper.toPurchaseItem( purchaseProductEntity ) );
        }

        return list1;
    }

    protected List<PurchaseProductEntity> purchaseItemListToPurchaseProductEntityList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseProductEntity> list1 = new ArrayList<PurchaseProductEntity>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( purchaseItemMapper.toPurchaseProductEntity( purchaseItem ) );
        }

        return list1;
    }
}
