/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.onlinebank.resources;

import com.mybank.onlinebank.model.Transaction;
import com.mybank.onlinebank.services.TransactionServices;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adrian
 */

/* code for this API is built with the help of the tutorials below: */
/* https://www.tutorialspoint.com/restful/restful_methods.htm */
/* https://javabrains.io/courses/javaee_jaxrs/lessons/What-Is-JAXRS */


@Path("/transactions")
@Produces(value={MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class TransactionResources {
    
    TransactionServices tServices = new TransactionServices();
    
    @GET
    public List<Transaction> getAllTransactions() {
        return tServices.getAllTransactions();
    } 
    @GET
    @Path("/{tID}")
    public Transaction getTransaction(@PathParam("tID") int tID) {
        return tServices.getTransaction(tID);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Transaction createTransactionXML(@FormParam("tID") int tID,
            @FormParam("description") String description, 
            @FormParam("type") String type,
            @FormParam("createdAt") Date createdAt,
            @FormParam("amount") double amount,
            @Context HttpServletResponse servletResponse) throws IOException{ 
        Transaction t = new Transaction(tID, description, type, createdAt, amount); 
        return tServices.addTransaction(t);
    }     
    
    /* API to update a Transaction from values entered in a form*/
    @PUT
    @Path("/{tID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Transaction updateTransaction(@PathParam("tID") long tID, Transaction transaction){
        transaction.setTrID(tID);
        return tServices.updateTransaction(transaction);
    }
    
    /* API to delete a Transaction by looking for its ID */
    @DELETE
    @Path("/{tID}")
    public void deleteTransaction(@PathParam("tID") long tID){
        tServices.deleteTransaction(tID);
    }
    
}
