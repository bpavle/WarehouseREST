/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.service;

import com.etf.rms.warehouse.dao.OrderDetailsDao;
import com.etf.rms.warehouse.dao.ShipperDao;
import com.etf.rms.warehouse.dao.EmployeeDao;
import com.etf.rms.warehouse.dao.OrderDao;
import com.etf.rms.warehouse.dao.ResourcesManager;
import com.etf.rms.warehouse.data.OrderDetails;
import com.etf.rms.warehouse.data.Shipper;
import com.etf.rms.warehouse.data.Employee;
import com.etf.rms.warehouse.data.Order;
import com.etf.rms.warehouse.exception.ResourceException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pikacu
 */
public class OrderService {
    private static final OrderService instance = new OrderService();
   private OrderService(){};
   public static OrderService getInstance(){
       return instance;
   }
   
   public int addNewOrder(Order order) throws SQLException, ResourceException{
       Connection con =  ResourcesManager.getConnection();
       int id = OrderDao.getInstance().insert(order, con);
       ResourcesManager.closeConnection(con);
       
       return id;
   }
   
   public Order findOrder(int orderId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       Order order = OrderDao.getInstance().find(orderId, con);
       ResourcesManager.closeConnection(con);
       return order;
   }
   
   public ArrayList<Order> findAllOrders() throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Order> list = new ArrayList<Order>();
       list = OrderDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   public void updateOrder(Order order) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       OrderDao.getInstance().update(order, con);
       ResourcesManager.closeConnection(con);
       
   }
   
   public void deleteOrder(int orderId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       OrderDao.getInstance().delete(orderId, con);
       ResourcesManager.closeConnection(con);
   }
   
   
  
   
   public int addNewEmployee(Employee employee) throws SQLException, ResourceException{
       Connection con =  ResourcesManager.getConnection();
       int id = EmployeeDao.getInstance().insert(employee, con);
       ResourcesManager.closeConnection(con);
       
       return id;
   }
   
   public Employee findEmployee(int employeeId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       Employee employee = EmployeeDao.getInstance().find(employeeId, con);
       ResourcesManager.closeConnection(con);
       return employee;
   }
   
   public ArrayList<Employee> findAllEmployees() throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Employee> list = new ArrayList<Employee>();
       list = EmployeeDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   public void updateEmployee(Employee employee) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       EmployeeDao.getInstance().update(employee, con);
       ResourcesManager.closeConnection(con);
       
   }
   
   public void deleteEmployee(int employeeId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       EmployeeDao.getInstance().delete(employeeId, con);
       ResourcesManager.closeConnection(con);
   }
   

   
   public int addNewShipper(Shipper shipper) throws SQLException, ResourceException{
       Connection con =  ResourcesManager.getConnection();
       int id = ShipperDao.getInstance().insert(shipper, con);
       ResourcesManager.closeConnection(con);
       
       return id;
   }
   
   public Shipper findShipper(int shipperId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       Shipper shipper = ShipperDao.getInstance().find(shipperId, con);
       ResourcesManager.closeConnection(con);
       return shipper;
   }
   
   public ArrayList<Shipper> findAllShippers() throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Shipper> list = new ArrayList<Shipper>();
       list = ShipperDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   public void updateShipper(Shipper shipper) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       ShipperDao.getInstance().update(shipper, con);
       ResourcesManager.closeConnection(con);
       
   }
   
   public void deleteShipper(int shipperId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       ShipperDao.getInstance().delete(shipperId, con);
       ResourcesManager.closeConnection(con);
   }
   
   
 
   
   public int addNewOrderDetails(OrderDetails orderDetails) throws SQLException, ResourceException{
       Connection con =  ResourcesManager.getConnection();
       int id = OrderDetailsDao.getInstance().insert(orderDetails, con);
       ResourcesManager.closeConnection(con);
       
       return id;
   }
   
   public OrderDetails findOrderDetails(int orderDetailsId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       OrderDetails orderDetails = OrderDetailsDao.getInstance().find(orderDetailsId, con);
       ResourcesManager.closeConnection(con);
       return orderDetails;
   }
   
   public ArrayList<OrderDetails> findAllOrderDetails() throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<OrderDetails> list = new ArrayList<OrderDetails>();
       list = OrderDetailsDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   public void updateOrderDetails(OrderDetails orderDetails) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       OrderDetailsDao.getInstance().update(orderDetails, con);
       ResourcesManager.closeConnection(con);
       
   }
   
   public void deleteOrderDetails(int orderDetailsId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       OrderDetailsDao.getInstance().delete(orderDetailsId, con);
       ResourcesManager.closeConnection(con);
   }

   
   
   
   
    
}
