/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.onlinebank.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrian
 */

/* code for this API is built with the help of the tutorials below: */
    /* https://www.tutorialspoint.com/restful/restful_methods.htm */
/* https://javabrains.io/courses/javaee_jaxrs/lessons/What-Is-JAXRS */

@XmlRootElement
public class Account {
    
    private long accountId;
    private String accountNo;
    private String sortCode;
    private String type;
    private double balance;

    public Account() {
    }

    public Account(long accountId, String accountNo, String sortCode, String type, double balance) {
        this.accountId = accountId;
        this.accountNo = accountNo;
        this.sortCode = sortCode;
        this.type = type;
        this.balance = balance;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }        
}
