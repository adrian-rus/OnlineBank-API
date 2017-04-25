/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.onlinebank.model;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Customer.java
 * @author Adrian Rus
 * 25/03/2017
 */

/* code for this API is built with the help of the tutorials below: */
/* https://www.tutorialspoint.com/restful/restful_methods.htm */
/* https://javabrains.io/courses/javaee_jaxrs/lessons/What-Is-JAXRS */

@XmlRootElement
public class Customer {
    
    /*data members */
    private long id;
    private String name;
    private String address;
    private String email;
    private String password;
    private Map<Long, Account> accounts = new HashMap<>();

    
    /*constructors*/
    public Customer() {
    }

    public Customer(long id, String name, String address, String email, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    /* Getters and setters */
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient /*it does not display all the accounts that a customer has when pulling a Customer */
    public Map<Long, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }
}
