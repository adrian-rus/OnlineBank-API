/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.onlinebank.services;

import com.mybank.onlinebank.database.DatabaseClass;
import com.mybank.onlinebank.model.Account;
import com.mybank.onlinebank.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adrian
 */

/* code for this API is built with the help of the tutorials below: */
/* https://www.tutorialspoint.com/restful/restful_methods.htm */
/* https://javabrains.io/courses/javaee_jaxrs/lessons/What-Is-JAXRS */

public class AccountServices {
    
    private Map<Long, Customer> customers = DatabaseClass.getCustomers();
   
   /* method to get all the list with all accounts */
    public List<Account> getAllAccounts(long customerId) { 
        Map<Long, Account> accounts = customers.get(customerId).getAccounts();
        return new ArrayList<Account>(accounts.values());
    }; 
        
    /* returning details of an Account by going through the Accounts list and searching for their ID*/
    public Account getAccount(long customerId, long accountId) {
        Map<Long, Account> accounts = customers.get(customerId).getAccounts();
        return accounts.get(accountId);
    }
    /* adding an Account to the Accounts List */
    public Account addAccount(long customerId, Account account){ 
        Map<Long, Account> accounts = customers.get(customerId).getAccounts();
        account.setAccountId(accounts.size()+1);
        accounts.put(account.getAccountId(),account);
        return account;
   }
    /* update an Account by getting the account number */
    public Account updateAccount(long customerId, Account account){
        Map<Long, Account> accounts = customers.get(customerId).getAccounts();
        if (account.getAccountId() <= 0){
            return null;
        }
        accounts.put(account.getAccountId(), account);
        return account;
    }
    
    /*deleting a account from the list */
    public Account deleteAccount(long customerId, long accountId){
        Map<Long, Account> accounts = customers.get(customerId).getAccounts();
        return accounts.remove(accountId);
    }
    
}
