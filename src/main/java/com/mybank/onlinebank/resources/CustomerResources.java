/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.onlinebank.resources;

import com.mybank.onlinebank.model.Customer;
import com.mybank.onlinebank.services.CustomerServices;
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
 * CustomerResources.java
 * @author Adrian Rus
 * 25/03/2017
 */

/* code for this API is built with the help of the tutorials below: */
/* https://www.tutorialspoint.com/restful/restful_methods.htm */
/* https://javabrains.io/courses/javaee_jaxrs/lessons/What-Is-JAXRS */

@Path("/customers")
@Produces(value={MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CustomerResources {
    
    CustomerServices customerServices = new CustomerServices();
       
    /* API to receive all the Customers in JSON format*/
    @GET
    public List<Customer> getCustomersJSON() {
        return customerServices.getAllCustomers();
    } 
    
    /* API to create a new Customer in JSON format from values entered in a form*/
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Customer addCustomer(@FormParam("id") long id, 
            @FormParam("name") String name, 
            @FormParam("address") String address, 
            @FormParam("email") String email,
            @FormParam("password") String password,
            @Context HttpServletResponse servletResponse){
        Customer customer = new Customer(id, name, address, email, password);
        return customerServices.addCustomer(customer);
    }
    /*
    public Response addCustomer(Customer customer, @Context UriInfo uriInfo) throws URISyntaxException {
        Customer newCustomer = customerServices.addCustomer(customer);
        String newId = String.valueOf(newCustomer.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .entity(newCustomer)
                .build();
    }*/
    
    /* API to update a Customer in JSON format from values entered in a form*/
    @PUT
    @Path("/{customerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Customer updateCustomer(@PathParam("customerId") long customerId, Customer customer){
        customer.setId(customerId);
        return customerServices.updateCustomer(customer);
    }
    
    /* API to delete a Customer by looking for his ID */
    @DELETE
    @Path("/{customerId}")
    public void deleteCustomerJSON(@PathParam("customerId") long customerId){
        customerServices.deleteCustomer(customerId);
    }
    
    /* API to receive a Customer details in JSON format from calling his ID */
    @GET
    @Path("/{customerId}")
    public Customer getCustomerByIdJSON(@PathParam("customerId") long customerId){
       return customerServices.getCustomer(customerId);
    }
    
    /*Method to link CustomersResources with the AccountResources */
    @Path("/{customerId}/accounts")
    public AccountResources getAccountResources(){
        return new AccountResources();
    }
   
}
