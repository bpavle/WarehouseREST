/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.dao;

import com.etf.rms.warehouse.data.Order;
import com.etf.rms.warehouse.data.OrderDetails;
import com.etf.rms.warehouse.data.Product;
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
public class OrderDetailsDao {
    private static final OrderDetailsDao instance = new OrderDetailsDao();
    
    private OrderDetailsDao(){
        
    }

   public static OrderDetailsDao getInstance() {
        return instance;
    }
   
   public OrderDetails find(int orderDetailsId,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       OrderDetails orderDetails = null;
       
           
       String sql="SELECT * FROM OrderDetails where OrderDetails_id = ?";
       
       try{
       ps = con.prepareStatement(sql);
       ps.setInt(1, orderDetailsId);
       rs = ps.executeQuery();
       
       if(rs.next()){
           Order order = OrderDao.getInstance().find(rs.getInt("Orders_id"),con);
           Product product = ProductDao.getInstance().find(rs.getInt("Products_id"),con);
           orderDetails = new OrderDetails(orderDetailsId,order,product,rs.getInt("Quantity"));
       }
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return orderDetails;
       
       
   }
   
   
   public ArrayList<OrderDetails> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       ArrayList<OrderDetails> list;
       list = new ArrayList<OrderDetails>();
       
           
       String sql="SELECT * FROM OrderDetails";
       
       try{
       ps = con.prepareStatement(sql);
     
       rs = ps.executeQuery();
       
       while(rs.next()){
           Order order = OrderDao.getInstance().find(rs.getInt("Orders_id"),con);
           Product product = ProductDao.getInstance().find(rs.getInt("Products_id"),con);
           OrderDetails orderDetails = new OrderDetails(rs.getInt("OrderDetails_id"),order,product,rs.getInt("Quantity"));
       list.add(orderDetails);
       }
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
   
   
   public int insert(OrderDetails orderDetails,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       int id=-1;
       String sql = "INSERT INTO orderDetails(Products_id,Orders_id,Quantity) VALUES(?,?,?)";
       try{
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           //ps.setInt(1, orderDetails.getOrderDetailsId());
           ps.setInt(1,orderDetails.getProduct().getProductId());
           ps.setInt(2, orderDetails.getOrder().getOrderId());
           ps.setInt(3, orderDetails.getQuantity());
          
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
   
   public void update(OrderDetails orderDetails,Connection con) throws SQLException{
       PreparedStatement ps = null;
       
       
       String sql = "UPDATE orderDetailss SET OrderDetails_id=?,Products_id=?,Orders_id=?,Quantity=?";
       
       try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, orderDetails.getOrderDetailsId());
           ps.setInt(2,orderDetails.getProduct().getProductId());
           ps.setInt(3, orderDetails.getOrder().getOrderId());
           ps.setInt(4, orderDetails.getQuantity());
           ps.executeUpdate();
           
       }
       finally{
           ResourcesManager.closeResources(null,ps);
       }
       
       
   }
   
   public void delete(int orderDetailsId,Connection con) throws SQLException{
       PreparedStatement ps =null;
       
       String sql = "DELETE FROM OrderDetails where OrderDetails_id=?";
       
       try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, orderDetailsId);
        ps.executeUpdate();
       }
       finally{
           ResourcesManager.closeResources(null,ps);
       }
   }
}
