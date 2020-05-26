/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.dao;

import com.etf.rms.warehouse.data.Product;
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
class ProductDao {
    
    
    private static final ProductDao instance = new ProductDao();
    
    private ProductDao(){
        
    }

   public static ProductDao getInstance() {
        return instance;
    }
   
   protected Product find(int productId,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       Product product = null;
       
           
       String sql="SELECT * FROM Products where Products_Id = ?";
       
       try{
       ps = con.prepareStatement(sql);
       ps.setInt(1, productId);
       rs = ps.executeQuery();
       
       if(rs.next()){
           Supplier supplier = SupplierDao.getInstance().find(rs.getInt("Suppliers_id"), con);
           
           product = new Product(productId,
                   rs.getString("ProductName"),
                   supplier,
                   rs.getString("ProductCategory"),
                   Double.parseDouble(rs.getString("PricePerUnit")));
       }
       
       }
       finally{
           ResourcesManager.closeResources(ps, rs);
       }
       return product;
       
       
   }
   
   protected int insert(Product product,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       int id=-1;
       String sql = "INSERT INTO products(ProductName,Suppliers_id,ProductCategory,PricePerUnit) VALUES(?,?,?,?)";
       try{
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, product.getProductName());
           ps.setInt(2,product.getSupplier().getSupplierId());
           ps.setString(3,product.getProductCategory());
           ps.setDouble(4,product.getPricePerUnit());
          
           
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
   
   protected void update(Product product,Connection con) throws SQLException{
       PreparedStatement ps = null;
       
       
       String sql = "UPDATE products SET ProductName=?,Suppliers_id=?,ProductCategory=?,PricePerUnit=?";
       
       try{
           ps = con.prepareStatement(sql);
           ps.setString(1,product.getProductName());
           ps.setInt(2,product.getSupplier().getSupplierId());
           ps.setString(3,product.getProductCategory());
           ps.setDouble(4,product.getPricePerUnit());
           ps.executeUpdate();
           
       }
       finally{
           ResourcesManager.closeResources(ps,null);
       }
       
       
   }
   
   protected void delete(int productId,Connection con) throws SQLException{
       PreparedStatement ps =null;
       
       String sql = "DELETE FROM products where Products_id=?";
       
       try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        ps.executeUpdate();
       }
       finally{
           ResourcesManager.closeResources(ps, null);
       }
   }
    
}
