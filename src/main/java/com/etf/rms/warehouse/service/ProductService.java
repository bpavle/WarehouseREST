/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.service;

import com.etf.rms.warehouse.dao.ProductDao;
import com.etf.rms.warehouse.dao.ResourcesManager;
import com.etf.rms.warehouse.dao.SupplierDao;
import com.etf.rms.warehouse.data.Product;
import com.etf.rms.warehouse.data.Supplier;
import com.etf.rms.warehouse.exception.ResourceException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Pikacu
 */
public class ProductService {
    
    private static final ProductService instance = new ProductService();
    private ProductService(){};
    public static ProductService getInstance(){
        return instance;
    }
    
    public int addNewProduct(Product product) throws SQLException, ResourceException{
        Connection con = null;        
        
        con = ResourcesManager.getConnection();
     
        int id = ProductDao.getInstance().insert(product, con);    
        ResourcesManager.closeConnection(con);
        return id;
    }
    
    public int addNewSupplier(Supplier supplier) throws SQLException, ResourceException{
        Connection con = null;        
        
            con = ResourcesManager.getConnection();
            int id = SupplierDao.getInstance().insert(supplier, con);    
            ResourcesManager.closeConnection(con);
        
            
        
        return id;
       
        
    }
    
    public Product findProduct(int productId) throws SQLException{
        Connection con = null;
        
            con = ResourcesManager.getConnection();
            Product product = ProductDao.getInstance().find(productId, con);
            return product;
        
    }
    public ArrayList<Product> findAllProducts() throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Product> list = new ArrayList<Product>();
       list = ProductDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
    public Supplier findSupplier(int supplierId) throws SQLException, ResourceException{
        Connection con = null;
        
            con = ResourcesManager.getConnection();
            Supplier supplier = SupplierDao.getInstance().find(supplierId, con);
            ResourcesManager.closeConnection(con);
            return supplier;
        
    }
    public ArrayList<Supplier> findAllSuppliers() throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Supplier> list = new ArrayList<Supplier>();
       list = SupplierDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }

    public void deleteProduct(int productId) throws SQLException, ResourceException{
        Connection con = null;
        
            con = ResourcesManager.getConnection();
            ProductDao.getInstance().delete(productId, con);
            ResourcesManager.closeConnection(con);
        
    }
    public void deleteSupplier(int supplierId) throws SQLException, ResourceException{
        Connection con = null;
        
            con = ResourcesManager.getConnection();
            SupplierDao.getInstance().delete(supplierId, con);
            ResourcesManager.closeConnection(con);
        
    }
    
    public void updateProduct(Product product) throws ResourceException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            ProductDao.getInstance().update(product, con);

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            
        } finally {
            ResourcesManager.closeConnection(con);
        }
    
}
    
    
     public void updateSupplier(Supplier supplier) throws ResourceException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            SupplierDao.getInstance().update(supplier, con);

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            
        } finally {
            ResourcesManager.closeConnection(con);
        }
    
}

   
}
