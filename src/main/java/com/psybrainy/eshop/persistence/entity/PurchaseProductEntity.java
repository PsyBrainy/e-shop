package com.psybrainy.eshop.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "purchase_product")
public class PurchaseProductEntity {

    @EmbeddedId
    private PuchaseProductPK id;

    private Integer quantity;

    private BigDecimal total;

    private Boolean status;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name = "purchase_id", insertable = false , updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false , updatable = false)
    private ProductEntity productEntity;

    public PuchaseProductPK getId() {
        return id;
    }

    public void setId(PuchaseProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public PurchaseEntity getPurchase() {
        return purchaseEntity;
    }

    public void setPurchase(PurchaseEntity purchaseEntity) {
        this.purchaseEntity = purchaseEntity;
    }

    public ProductEntity getProduct() {
        return productEntity;
    }

    public void setProduct(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
