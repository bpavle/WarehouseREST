/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.data;

/**
 *
 * @author Pikacu
 */
public class Employee {
   
    private int employeeId=-1;
    private String lastName;
    private String firstName;
    private String birthDate;

    public Employee() {
    }

    
     public Employee(int employeeId,String lastName, String firstName, String birthDate) {
        this.employeeId=employeeId;
         this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }
    
    public Employee(String lastName, String firstName, String birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    
    public int getEmployeeId() {
        return employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setEmployeeId(int employeesId) {
        this.employeeId = employeesId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Employees{" + "employeesId=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName + ", birthDate=" + birthDate + '}';
    }
    
    
    
}
