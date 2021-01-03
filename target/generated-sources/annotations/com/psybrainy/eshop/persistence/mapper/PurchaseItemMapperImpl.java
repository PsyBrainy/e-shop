package com.psybrainy.eshop.persistence.mapper;

import com.psybrainy.eshop.domain.PurchaseItem;
import com.psybrainy.eshop.persistence.entity.PuchaseProductPK;
import com.psybrainy.eshop.persistence.entity.PurchaseProductEntity;
import java.math.BigDecimal;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-03T16:28:22-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9.1 (Amazon.com Inc.)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(PurchaseProductEntity purchaseProductEntity) {
        if ( purchaseProductEntity == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        Integer productId = purchaseProductEntityIdProductId( purchaseProductEntity );
        if ( productId != null ) {
            purchaseItem.setProductId( productId );
        }
        if ( purchaseProductEntity.getQuantity() != null ) {
            purchaseItem.setQuantity( purchaseProductEntity.getQuantity() );
        }
        if ( purchaseProductEntity.getTotal() != null ) {
            purchaseItem.setTotal( purchaseProductEntity.getTotal().doubleValue() );
        }
        if ( purchaseProductEntity.getStatus() != null ) {
            purchaseItem.setActive( purchaseProductEntity.getStatus() );
        }

        return purchaseItem;
    }

    @Override
    public PurchaseProductEntity toPurchaseProductEntity(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        PurchaseProductEntity purchaseProductEntity = new PurchaseProductEntity();

        purchaseProductEntity.setId( purchaseItemToPuchaseProductPK( purchaseItem ) );
        purchaseProductEntity.setQuantity( purchaseItem.getQuantity() );
        purchaseProductEntity.setTotal( BigDecimal.valueOf( purchaseItem.getTotal() ) );
        purchaseProductEntity.setStatus( purchaseItem.isActive() );

        return purchaseProductEntity;
    }

    private Integer purchaseProductEntityIdProductId(PurchaseProductEntity purchaseProductEntity) {
        if ( purchaseProductEntity == null ) {
            return null;
        }
        PuchaseProductPK id = purchaseProductEntity.getId();
        if ( id == null ) {
            return null;
        }
        Integer productId = id.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    protected PuchaseProductPK purchaseItemToPuchaseProductPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        PuchaseProductPK puchaseProductPK = new PuchaseProductPK();

        puchaseProductPK.setProductId( purchaseItem.getProductId() );

        return puchaseProductPK;
    }
}
