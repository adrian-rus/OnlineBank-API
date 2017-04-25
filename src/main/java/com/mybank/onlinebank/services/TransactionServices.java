/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.onlinebank.services;

import com.mybank.onlinebank.database.DatabaseClass;
import com.mybank.onlinebank.model.Transaction;
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

public class TransactionServices {
    
    private Map<Long, Transaction> transactions = DatabaseClass.getTransactions();
    
    /* method to get all the list with all transactions */
    public List<Transaction> getAllTransactions() { 
      return new ArrayList<Transaction>(transactions.values());
    }; 
        
    /* returning details of a Transaction by going through the transactions list and searching for their ID*/
    public Transaction getTransaction(long id) {
        return transactions.get(id);
    }
    /* adding a transaction to the transactions List */
    public Transaction addTransaction(Transaction transaction){ 
      transaction.setTrID(transactions.size()+1);
      transactions.put(transaction.getTrID(), transaction);
      return transaction;
   }
    /* updating a custome instance */
    public Transaction updateTransaction(Transaction transaction){
        if (transaction.getTrID() <=0 ){
            return null;
        }
        transactions.put(transaction.getTrID(), transaction);
        return transaction;
    }
    
    /*deleting a transaction from the list */
    public Transaction deleteTransaction(long id){
        return transactions.remove(id);
    }
}
