package com.mybank.onlinebank.services;

import com.mybank.onlinebank.database.DatabaseClass;
import com.mybank.onlinebank.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * CustomerServices.java
 * @author Adrian Rus
 * 25/03/17
 */

/* code for this API is built with the help of the tutorials below: */
/* https://www.tutorialspoint.com/restful/restful_methods.htm */
/* https://javabrains.io/courses/javaee_jaxrs/lessons/What-Is-JAXRS */

public class CustomerServices {
    
    private Map<Long, Customer> customers = DatabaseClass.getCustomers();
    
    /*public CustomerServices(){
        customers.put(1L, new Customer(1, "Adrian", "1 Main St", "adrian@mail.com", "147258"));
    }*/
    
    /* method to get all the list with all customers */
    public List<Customer> getAllCustomers() { 
      return new ArrayList<Customer>(customers.values());
    }; 
        
    /* returning details of a Customer by going through the Customers list and searching for their ID*/
    public Customer getCustomer(long id) {
        return customers.get(id);
    }
    /* adding a customer to the customer List */
    public Customer addCustomer(Customer customer){ 
      customer.setId(customers.size()+1);
      customers.put(customer.getId(),customer);
      return customer;
   }
    
    /* updating a custome instance */
    public Customer updateCustomer(Customer customer){
        if (customer.getId() <=0 ){
            return null;
        }
        customers.put(customer.getId(), customer);
        return customer;
    }
    
    /*deleting a customer from the list */
    public Customer deleteCustomer(long id){
        return customers.remove(id);
    }
    
    
}

