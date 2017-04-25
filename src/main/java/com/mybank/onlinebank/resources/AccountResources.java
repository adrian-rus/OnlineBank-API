/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.onlinebank.resources;

import com.mybank.onlinebank.model.Account;
import com.mybank.onlinebank.services.AccountServices;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * AccountResources.java
 * @author Adrian Rus
 * @date 3/04/2017
 */

/* code for this API is built with the help of the tutorials below: */
/* https://www.tutorialspoint.com/restful/restful_methods.htm */
/* https://javabrains.io/courses/javaee_jaxrs/lessons/What-Is-JAXRS */

@Path("/")
@Produces(value={MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AccountResources {
    
    private AccountServices accountServices = new AccountServices();
      
    @GET
    public List<Account> getAllAccountsJSON(@PathParam("customerId") long customerId) {
        return accountServices.getAllAccounts(customerId);
    }
    
    @GET
    @Path("/{accountId}")
    public Account getAccountJSON(@PathParam("customerId") long customerId, 
            @PathParam("accountId") long accountId) {
        return accountServices.getAccount(customerId, accountId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Account addAccountJSON(@PathParam("customerId")long customerId, Account account){
        return accountServices.addAccount(customerId, account);
    } 
    
    @PUT
    @Path("/{accountId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Account updateAccountJSON(@PathParam("customerId") long customerId,
            @PathParam("accountId") long accountId, Account account){
        account.setAccountId(accountId);
        return accountServices.updateAccount(customerId, account);
    }
    
    @DELETE
    @Path("/{accountId}")
    public void deleteAccountJSON(@PathParam("customerId") long customerId,
            @PathParam("acountId") long accountId){
        accountServices.deleteAccount(customerId, accountId);
    }
}
