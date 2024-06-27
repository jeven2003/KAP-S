package com.jeven.Kap.s.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {

    private @Id

    @GeneratedValue Long id;
    private String name;
    private String address;
    private String email;
    private int age;

    Users(){}
    
    //Constructors
    public Users(String name, String address, String email, int age) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;

    }
    //setters
    public void setname(String name) {
        this.name = name;
    }
    public void setaddress(String address) {
        this.address = address;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public void setage(int age) {
        this.age = age;
    }
    //getters
    public Long getId() {
        return id;
    }
    public String getname() {
        return name;
    }
    public String getaddress() {
        return address;
    }
    public String getemail() {
        return email;
    }
    public int getage() {
        return age;
    }



}
