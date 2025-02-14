/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.rest;

import com.etf.rms.warehouse.data.Product;
import com.etf.rms.warehouse.data.Supplier;
import com.etf.rms.warehouse.exception.ResourceException;
import com.etf.rms.warehouse.service.ProductService;
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

@Path("/product")
public class ProductRest {
    private final ProductService productService = ProductService.getInstance();
    
    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("productId") int productId) throws SQLException  {
        return productService.findProduct(productId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getAllProducts() throws SQLException, ResourceException  {
        return productService.findAllProducts();
    }
    
    @GET
    @Path("/supplier/{supplierId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Supplier getSupplierById(@PathParam("supplierId") int supplierId) throws SQLException, ResourceException  {
        return productService.findSupplier(supplierId);
    }
    
    @GET
    @Path("/supplier")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Supplier> getAllSuppliers() throws SQLException, ResourceException  {
        return productService.findAllSuppliers();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) throws SQLException, ResourceException{
            productService.addNewProduct(product);
            return Response.ok().build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product product) throws ResourceException{
            productService.updateProduct(product);
            return Response.ok().build();
    }
    
    @DELETE
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("productId") int productId) throws SQLException, ResourceException  {
            productService.deleteProduct(productId);
            return Response.ok().build();
    }
}
