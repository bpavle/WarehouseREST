/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.rest;

import com.etf.rms.warehouse.data.Customer;
import com.etf.rms.warehouse.exception.ResourceException;
import com.etf.rms.warehouse.service.CustomerService;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Pikacu
 */
@Path("/customer")
public class CustomerRest {
     private final CustomerService customerService = CustomerService.getInstance();
    
    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@PathParam("customerId") int customerId) throws SQLException, ResourceException  {
        return customerService.findCustomer(customerId);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Customer> getAllCustomers() throws SQLException, ResourceException  {
        return customerService.findAllCustomers();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer customer) throws SQLException, ResourceException{
            customerService.addNewCustomer(customer);
            return Response.ok().build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer(Customer customer) throws ResourceException, SQLException{
            customerService.updateCustomer(customer);
            return Response.ok().build();
    }
    
    @DELETE
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("customerId") int customerId) throws SQLException, ResourceException  {
            customerService.deleteCustomer(customerId);
            return Response.ok().build();
    }
}
