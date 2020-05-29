/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.service;

import com.etf.rms.warehouse.dao.CustomerDao;
import com.etf.rms.warehouse.dao.ResourcesManager;
import com.etf.rms.warehouse.data.Customer;
import com.etf.rms.warehouse.exception.ResourceException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pikacu
 */
public class CustomerService{
    
   private static final CustomerService instance = new CustomerService();
   private CustomerService(){};
   public static CustomerService getInstance(){
       return instance;
   }
   
   public int addNewCustomer(Customer customer) throws SQLException, ResourceException{
       Connection con =  ResourcesManager.getConnection();
       int id = CustomerDao.getInstance().insert(customer, con);
       ResourcesManager.closeConnection(con);
       
       return id;
   }
   
   public Customer findCustomer(int customerId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       Customer customer = CustomerDao.getInstance().find(customerId, con);
       ResourcesManager.closeConnection(con);
       return customer;
   }
   
   public ArrayList<Customer> findAllCustomers() throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Customer> list = new ArrayList<Customer>();
       list = CustomerDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   public void updateCustomer(Customer customer) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       CustomerDao.getInstance().update(customer, con);
       ResourcesManager.closeConnection(con);
       
   }
   
   public void deleteCustomer(int customerId) throws SQLException, ResourceException{
       Connection con = ResourcesManager.getConnection();
       CustomerDao.getInstance().delete(customerId, con);
       ResourcesManager.closeConnection(con);
   }
   
    
}
