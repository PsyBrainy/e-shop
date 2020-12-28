package com.psybrainy.eshop.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "purchase_product")
public class PurchaseProduct {

    @EmbeddedId
    private PuchaseProductPK id;

    private Integer quantity;

    private BigDecimal total;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "purchase_id", insertable = false , updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false , updatable = false)
    private Product product;

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

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
