/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.onlinebank.database;

import com.mybank.onlinebank.model.Account;
import com.mybank.onlinebank.model.Customer;
import com.mybank.onlinebank.model.Transaction;
import java.util.HashMap;
import java.util.Map;

/**
 * DatabaseClass.java
 * @author Adrian Rus
 * @date 03/04/2017
 */

/* code for this API is built with the help of the tutorials below: */
/* https://www.tutorialspoint.com/restful/restful_methods.htm */
/* https://javabrains.io/courses/javaee_jaxrs/lessons/What-Is-JAXRS */

public class DatabaseClass {
    
    private static Map<Long, Customer> customers = new HashMap<>();
    private static Map<String, Account> accounts = new HashMap<>();
    private static Map<Long, Transaction> transactions = new HashMap<>();

    public static Map<Long, Customer> getCustomers(){
        return customers;
    }
    
    public static Map<String, Account> getAccounts(){
        return accounts;
    }
    public static Map<Long, Transaction> getTransactions(){
        return transactions;
    }
}
