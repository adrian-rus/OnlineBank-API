/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.onlinebank.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrian
 */

/* code for this API is built with the help of the tutorials below: */
/* https://www.tutorialspoint.com/restful/restful_methods.htm */
/* https://javabrains.io/courses/javaee_jaxrs/lessons/What-Is-JAXRS */

@XmlRootElement
public class Transaction{
   
    private long trID;
    private String description;
    private String type;
    private Date createdAt;
    private double amount;

    public Transaction() {
    }


    public Transaction(long trID, String description, String type, Date createdAt, double amount) {
        this.trID = trID;
        this.description = description;
        this.type = type;
        this.createdAt = createdAt;
        this.amount = amount;
    }

    public long getTrID() {
        return trID;
    }

    public void setTrID(long trID) {
        this.trID = trID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
        
}
