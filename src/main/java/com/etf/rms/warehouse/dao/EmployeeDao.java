/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.dao;

import com.etf.rms.warehouse.data.Employee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Pikacu
 */
public class EmployeeDao {
    
    private static final EmployeeDao instance = new EmployeeDao();
    
    private EmployeeDao(){};
    
    public static EmployeeDao getInstance(){
        return instance;
    }
    public Employee find(int employeeId,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       Employee employee = null;
       
           
       String sql="SELECT * FROM Employees where Employees_id = ?";
       
       try{
       ps = con.prepareStatement(sql);
       ps.setInt(1, employeeId);
       rs = ps.executeQuery();
       
       if(rs.next()){
           employee = new Employee(employeeId,
                   rs.getString("LastName"),
                   rs.getString("FirstName"),
                   rs.getString("BirthDate"));
       }
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return employee;
       
       
   }
    
    
    public ArrayList<Employee> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       ArrayList<Employee> list;
       list = new ArrayList<Employee>();
       
           
       String sql="SELECT * FROM Employees";
       
       try{
       ps = con.prepareStatement(sql);
       
       rs = ps.executeQuery();
       
       while(rs.next()){
          Employee employee = new Employee(rs.getInt("Employees_id"),
                   rs.getString("LastName"),
                   rs.getString("FirstName"),
                   rs.getString("BirthDate"));
          
          list.add(employee);
       }
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
    
   
   public int insert(Employee employee,Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
       int id=-1;
       String sql = "INSERT INTO employees(LastName,FirstName,BirthDate) VALUES(?,?,?)";
       try{
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, employee.getLastName());
           ps.setString(2,employee.getFirstName());
           ps.setDate(3,Date.valueOf(employee.getBirthDate()));
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
   
   public void update(Employee employee,Connection con) throws SQLException{
       PreparedStatement ps = null;
       
       
       String sql = "UPDATE employees SET FirstName=?,LastName=?,BirthDate=?";
       
       try{
           ps = con.prepareStatement(sql);
           ps.setString(1,employee.getFirstName());
           ps.setString(2,employee.getLastName());
           ps.setString(3,employee.getBirthDate());
           ps.executeUpdate();
           
       }
       finally{
           ResourcesManager.closeResources(null,ps);
       }
       
       
   }
   
   public void delete(int employeeId,Connection con) throws SQLException{
       PreparedStatement ps =null;
       
       String sql = "DELETE FROM employees where Employees_id=?";
       
       try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, employeeId);
        ps.executeUpdate();
       }
       finally{
           ResourcesManager.closeResources(null,ps);
       }
   }
}
