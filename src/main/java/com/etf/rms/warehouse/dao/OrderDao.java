/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.dao;

import com.etf.rms.warehouse.data.Customer;
import com.etf.rms.warehouse.data.Employee;
import com.etf.rms.warehouse.data.Order;
import com.etf.rms.warehouse.data.Shipper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pikacu
 */
public class OrderDao {
    
    private static final OrderDao instance = new OrderDao();
    
    private OrderDao(){
        
    }

   public static OrderDao getInstance() {
        return instance;
    }
   
   public Order find(int orderId,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       Order order = null;
       
           
       String sql="SELECT * FROM Orders where Orders_id = ?";
       
       try{
       ps = con.prepareStatement(sql);
       ps.setInt(1, orderId);
       rs = ps.executeQuery();
       //Orders_id	OrderDate	Customers_id	Emoplyees_id	Shippers_id
       if(rs.next()){
           Customer customer = CustomerDao.getInstance().find(rs.getInt("Customers_id"), con);
           Employee employee = EmployeeDao.getInstance().find(rs.getInt("Employees_id"), con);
           Shipper shipper = ShipperDao.getInstance().find(rs.getInt("Shippers_id"),con);
           
           order = new Order(orderId,rs.getString("OrderDate"),customer,employee,shipper);
       }
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return order;
       
       
   }
   
   
   public ArrayList<Order> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       ArrayList<Order> list;
       list = new ArrayList<Order>();
       
           
       String sql="SELECT * FROM Orders";
       
       try{
       ps = con.prepareStatement(sql);
       
       rs = ps.executeQuery();
       //Orders_id	OrderDate	Customers_id	Emoplyees_id	Shippers_id
       while(rs.next()){
           Customer customer = CustomerDao.getInstance().find(rs.getInt("Customers_id"), con);
           Employee employee = EmployeeDao.getInstance().find(rs.getInt("Employees_id"), con);
           Shipper shipper = ShipperDao.getInstance().find(rs.getInt("Shippers_id"),con);
           
          Order order = new Order(rs.getInt("Orders_id"),rs.getString("OrderDate"),customer,employee,shipper);
       list.add(order);
       }
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
   
   public int insert(Order order,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       int id=-1;
       String sql = "INSERT INTO orders(OrderDate,Customers_id,Employees_id,Shippers_id) VALUES(?,?,?,?)";
       try{
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, order.getOrderDate());
           ps.setInt(2,order.getCustomer().getCustomerId());
           ps.setInt(3, order.getEmployee().getEmployeeId());
           ps.setInt(4, order.getShipper().getShipperId());
           ps.executeUpdate();
           
           //GENRATED KEYS JEDINA NEJASNA STVAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
           rs = ps.getGeneratedKeys();
           rs.next();
           
           id = rs.getInt(1);
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
        return id;
       
   }
   
   public void update(Order order,Connection con) throws SQLException{
       PreparedStatement ps = null;
       
       
       String sql = "UPDATE orders SET OrderDate=?,Customers_id=?,Employees_id=?,Shippers_id=?";
       
       try{
           ps = con.prepareStatement(sql);
           ps.setString(1,order.getOrderDate());
           ps.setInt(2,order.getCustomer().getCustomerId());
           ps.setInt(3, order.getEmployee().getEmployeeId());
           ps.setInt(4, order.getShipper().getShipperId());
           ps.executeUpdate();
           
       }
       finally{
           ResourcesManager.closeResources(null,ps);
       }
       
       
   }
   
   public void delete(int orderId,Connection con) throws SQLException{
       PreparedStatement ps =null;
       
       String sql = "DELETE FROM orders where Orders_id=?";
       
       try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, orderId);
        ps.executeUpdate();
       }
       finally{
           ResourcesManager.closeResources(null,ps);
       }
   }
    
}
