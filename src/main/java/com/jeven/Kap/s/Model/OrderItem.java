package com.jeven.Kap.s.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orderitemtbl")
public class OrderItem {

    private @Id
    @GeneratedValue Long id;
    private Long orderId;
    private Long productId;
    private int quantity;
    private double  price;

    OrderItem(){}
    
    //Constructors
    public OrderItem(Long orderId, Long productId, int quantity, double price) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity= quantity;
        this.price = price;

    }
    //setters
    public void setorderId(Long orderId) {
        this.orderId = orderId;
    }
    public void setproductId(Long productId) {
        this.productId = productId;
    }
    public void setquantity( int quantity) {
        this.quantity = quantity;
    }
    public void setprice(double price) {
        this.price = price;
    }
    //getters
    public Long getId() {
        return id;
    }
    public Long getorderId() {
        return orderId;
    }
    public Long getproductId() {
        return productId;
    }
    public double gettotalAmount() {
        return quantity;
    }
    public  double getprice() {
        return price;
    }
    



}
