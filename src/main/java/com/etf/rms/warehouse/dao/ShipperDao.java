/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.dao;

import com.etf.rms.warehouse.data.Shipper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pikacu
 */
class ShipperDao {
 
    private static final ShipperDao instance = new ShipperDao();
    
    private ShipperDao(){
        
    }

   public static ShipperDao getInstance() {
        return instance;
    }
   
   protected Shipper find(int shipperId,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       Shipper shipper = null;
       
           
       String sql="SELECT * FROM Shippers where Shippers_id = ?";
       
       try{
       ps = con.prepareStatement(sql);
       ps.setInt(1, shipperId);
       rs = ps.executeQuery();

       if(rs.next()){
           shipper = new Shipper(shipperId,rs.getString("ShipperName"),rs.getString("Phone"));
       }
       }
       finally{
           ResourcesManager.closeResources(ps, rs);
       }
       return shipper;
       
       
   }
   
   protected int insert(Shipper shipper,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       int id=-1;
       String sql = "INSERT INTO shippers(ShipperName,Phone) VALUES(?,?)";
       try{
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, shipper.getShipperName());
           ps.setString(2,shipper.getPhone());
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
   
   protected void update(Shipper shipper,Connection con) throws SQLException{
       PreparedStatement ps = null;
       
       
       String sql = "UPDATE shippers SET ShipperName=?,Phone=?";
       
       try{
           ps = con.prepareStatement(sql);
           ps.setString(1,shipper.getShipperName());
           ps.setString(2,shipper.getPhone());
           ps.executeUpdate();
           
       }
       finally{
           ResourcesManager.closeResources(ps,null);
       }
       
       
   }
   
   protected void delete(int shipperId,Connection con) throws SQLException{
       PreparedStatement ps =null;
       
       String sql = "DELETE FROM shippers where Shippers_id=?";
       
       try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, shipperId);
        ps.executeUpdate();
       }
       finally{
           ResourcesManager.closeResources(ps, null);
       }
   }
    
}
