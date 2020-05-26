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
public class Order {
 private int orderId;
private String orderDate;
private Customer customer;
private Employee employee;
private Shipper shipper;

    public Order() {
    }



    public Order(int orderId, String orderDate, Customer customer, Employee employee, Shipper shipper) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customer = customer;
        this.employee = employee;
        this.shipper = shipper;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customer;
    }

    public void setEmployeeId(Employee employee) {
        this.employee = employee;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer + ", employee=" + employee + ", shipper=" + shipper + '}';
    }



}
