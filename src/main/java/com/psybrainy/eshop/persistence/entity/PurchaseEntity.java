package com.psybrainy.eshop.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "puchase_id")
    private Integer purchaseId;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "commit")
    private String Commit;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private ClientEntity clientEntity;

    @OneToMany(mappedBy = "productEntity")
    private List<PurchaseProductEntity> products;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCommit() {
        return Commit;
    }

    public void setCommit(String commit) {
        Commit = commit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClientEntity getClient() {
        return clientEntity;
    }

    public void setClient(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public List<PurchaseProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseProductEntity> products) {
        this.products = products;
    }
}
