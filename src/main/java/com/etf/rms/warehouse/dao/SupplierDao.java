/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.dao;

import com.etf.rms.warehouse.data.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pikacu
 */
public class SupplierDao {
    
     private static final SupplierDao instance = new SupplierDao();
    
    private SupplierDao(){
        
    }

   public static SupplierDao getInstance() {
        return instance;
    }
   
   protected Supplier find(int supplierId,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       Supplier supplier = null;
       
           
       String sql="SELECT * FROM Suppliers where suppliersId = ?";
       
       try{
       ps = con.prepareStatement(sql);
       ps.setInt(1, supplierId);
       rs = ps.executeQuery();
       //Suppliers_id	SuplierName	ContactPerson	Address	City	PostCode	Country	Phone
       if(rs.next()){
           supplier = new Supplier(supplierId,
                   rs.getString("SupplierName"),
                   rs.getString("ContactPerson"),
                   rs.getString("Address"),
                   rs.getString("City"),
                   rs.getString("PostCode"),
                   rs.getString("Country"),
                   rs.getString("Phone")
           );
       }
       }
       finally{
           ResourcesManager.closeResources(ps, rs);
       }
       return supplier;
       
       
   }
   
   protected int insert(Supplier supplier,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       int id=-1;
       String sql = "INSERT INTO suppliers(SupplierName,ContactPerson,Address,City,PostCode,Country,Phone) VALUES(?,?,?,?,?,?,?)";
       try{
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, supplier.getSupplierName());
           ps.setString(2,supplier.getContactPerson());
           ps.setString(3,supplier.getAddress());
           ps.setString(4,supplier.getCity());
           ps.setString(5,supplier.getPostCode());
           ps.setString(6,supplier.getCountry());
           ps.setString(7, supplier.getPhone());
           ps.executeUpdate();
           
           //GENRATED KEYS JEDINA NEJASNA STVAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
           rs = ps.getGeneratedKeys();
           rs.next();
           
           id = rs.getInt(1);
       }
       finally{
           ResourcesManager.closeResources(ps,rs);
       }
        return id;
       
   }
   
   protected void update(Supplier supplier,Connection con) throws SQLException{
       PreparedStatement ps = null;
       
       
       String sql = "UPDATE suppliers SET SupplierName=?,ContactPerson=?,Address=?,City=?,PostCode=?,Country=?,Phone=?";
       
       try{
           ps = con.prepareStatement(sql);
           ps.setString(1,supplier.getSupplierName());
           ps.setString(2,supplier.getContactPerson());
           ps.setString(3,supplier.getAddress());
           ps.setString(4,supplier.getCity());
           ps.setString(5,supplier.getPostCode());
           ps.setString(6,supplier.getCountry());
           ps.setString(7,supplier.getPhone());
           ps.executeUpdate();
           
       }
       finally{
           ResourcesManager.closeResources(ps,null);
       }
       
       
   }
   
   protected void delete(int supplierId,Connection con) throws SQLException{
       PreparedStatement ps =null;
       
       String sql = "DELETE FROM suppliers where suppliersId=?";
       
       try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, supplierId);
        ps.executeUpdate();
       }
       finally{
           ResourcesManager.closeResources(ps, null);
       }
   }
    
}
