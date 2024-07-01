package com.jeven.Kap.s.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ordertbl")
public class Order {

    private @Id
    @GeneratedValue Long id;
    private Long userId;
    private double totalAmount;
    private String  status;

    Order(){}
    
    //Constructors
    public Order(Long orderId, Long userId, double totalAmount, String status) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;

    }
    //setters
    public void setuserId(Long userId) {
        this.userId = userId;
    }
    public void settotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setstatus(String status) {
        this.status = status;
    }
    //getters
    public Long getorderId() {
        return id;
    }
    public Long getuserId() {
        return userId;
    }
    public double getatotalAmount() {
        return totalAmount
        ;
    }
    public String getstatus() {
        return status;
    }
    



}
