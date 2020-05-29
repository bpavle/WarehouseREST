/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.dao;

import com.etf.rms.warehouse.data.Customer;
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
public class CustomerDao {

    private static final CustomerDao instance = new CustomerDao();
    
    private CustomerDao(){
        
    }

   public static CustomerDao getInstance() {
        return instance;
    }
   
   public Customer find(int customerId,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       Customer customer = null;
       
           
       String sql="SELECT * FROM Customers where Customers_id = ?";
       
       try{
       ps = con.prepareStatement(sql);
       ps.setInt(1, customerId);
       rs = ps.executeQuery();
       
       if(rs.next()){
           customer = new Customer(customerId,
                   rs.getString("CustomerName"),
                   rs.getString("ContactPerson"),
                   rs.getString("Address"),
                   rs.getString("City"),
                   rs.getString("PostCode"),
                   rs.getString("Country"));
       }
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return customer;
       
       
   }
   
   
   
   public ArrayList<Customer> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
      
       ArrayList<Customer> list;
       
       list = new ArrayList<Customer>();
       String sql="SELECT * FROM Customers";
       
       try{
       ps = con.prepareStatement(sql);
       
       rs = ps.executeQuery();
       
       while(rs.next()){
           Customer customer = new Customer(rs.getInt("Customers_id"),
                   rs.getString("CustomerName"),
                   rs.getString("ContactPerson"),
                   rs.getString("Address"),
                   rs.getString("City"),
                   rs.getString("PostCode"),
                   rs.getString("Country"));
           list.add(customer);
       }
       
       
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
   
   
   
   
   
   
   public int insert(Customer customer,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       int id=-1;
       String sql = "INSERT INTO customers(CustomerName,ContactPerson,Address,City,PostCode,Country) VALUES(?,?,?,?,?,?)";
       try{
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, customer.getCustomerName());
           ps.setString(2,customer.getContactPerson());
           ps.setString(3,customer.getAddress());
           ps.setString(4,customer.getCity());
           ps.setString(5,customer.getPostCode());
           ps.setString(6,customer.getCountry());
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
   
   public void update(Customer customer,Connection con) throws SQLException{
       PreparedStatement ps = null;
       
       
       String sql = "UPDATE customers SET CustomerName=?,ContactPerson=?,Address=?,City=?,PostCode=?,Country=?";
       
       try{
           ps = con.prepareStatement(sql);
           ps.setString(1,customer.getCustomerName());
           ps.setString(2,customer.getContactPerson());
           ps.setString(3,customer.getAddress());
           ps.setString(4,customer.getCity());
           ps.setString(5,customer.getPostCode());
           ps.setString(6,customer.getCountry());
           ps.executeUpdate();
           
       }
       finally{
           ResourcesManager.closeResources(null,ps);
       }
       
       
   }
   
   public void delete(int customerId,Connection con) throws SQLException{
       PreparedStatement ps =null;
       
       String sql = "DELETE FROM customers where Customers_id=?";
       
       try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, customerId);
        ps.executeUpdate();
       }
       finally{
           ResourcesManager.closeResources(null,ps);
       }
   }
    
}
