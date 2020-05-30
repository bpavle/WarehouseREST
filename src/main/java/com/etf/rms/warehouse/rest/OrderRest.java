/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.rest;


import com.etf.rms.warehouse.data.Order;
import com.etf.rms.warehouse.data.Employee;
import com.etf.rms.warehouse.data.Order;
import com.etf.rms.warehouse.data.OrderDetails;
import com.etf.rms.warehouse.data.Shipper;
import com.etf.rms.warehouse.data.Supplier;
import com.etf.rms.warehouse.exception.ResourceException;
import com.etf.rms.warehouse.service.OrderService;
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
@Path("/order")
public class OrderRest {
    private final OrderService orderService = OrderService.getInstance();
    
    
    
 
    
    
    @GET
    @Path("/shipper/{shipperId}")
    @Produces(MediaType.APPLICATION_JSON)  
    public Shipper getShipperById(@PathParam("shipperId") int shipperId) throws SQLException, ResourceException{
        
        return orderService.getInstance().findShipper(shipperId);
    }
    @GET
    @Path("/shipper")
    @Produces(MediaType.APPLICATION_JSON)  
    public ArrayList<Shipper> getAllShippers() throws SQLException, ResourceException{
        
        return orderService.getInstance().findAllShippers();
    }
    
    @GET
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)  
    public Employee getEmployeeById(@PathParam("id") int id) throws SQLException, ResourceException{
        
        return orderService.getInstance().findEmployee(id);
    }
    @GET
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)  
    public ArrayList<Employee> getAllEmployees() throws SQLException, ResourceException{
        
        return orderService.getInstance().findAllEmployees();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)  
    public Order getOrderById(@PathParam("id") int id) throws SQLException, ResourceException{
        
        return orderService.getInstance().findOrder(id);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)  
    public ArrayList<Order> getAllOrders() throws SQLException, ResourceException{
        
        return orderService.getInstance().findAllOrders();
    }
    
    
    @GET
    @Path("/orderdetails/{id}")
    @Produces(MediaType.APPLICATION_JSON)  
    public OrderDetails getOrderDetailsById(@PathParam("id") int id) throws SQLException, ResourceException{
        
        return orderService.getInstance().findOrderDetails(id);
    }
    @GET
    @Path("/orderdetails")
    @Produces(MediaType.APPLICATION_JSON)  
    public ArrayList<OrderDetails> getAllOrderDetails() throws SQLException, ResourceException{
        
        return orderService.getInstance().findAllOrderDetails();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(Order order) throws SQLException, ResourceException{
            orderService.addNewOrder(order);
            return Response.ok().build();
    }
    /*
    @POST
    @Path("/emplyee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee employee) throws SQLException, ResourceException{
            orderService.addNewEmployee(employee);
            return Response.ok().build();
    }
    
    @POST
    @Path("/shipper")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addShipper(Shipper shipper) throws SQLException, ResourceException{
            orderService.addNewShipper(shipper);
            return Response.ok().build();
    }
    
    
    @POST
    @Path("/orderdetails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrderDetails(OrderDetails orderDetails) throws SQLException, ResourceException{
            orderService.addNewOrderDetails(orderDetails);
            return Response.ok().build();
    }
    */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrder(Order order) throws ResourceException, SQLException{
            orderService.updateOrder(order);
            return Response.ok().build();
    }
    
    @DELETE
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrder(@PathParam("orderId") int orderId) throws SQLException, ResourceException  {
            orderService.deleteOrder(orderId);
            return Response.ok().build();
    }
    
}
