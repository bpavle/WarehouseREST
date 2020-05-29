/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.data;

import java.io.Serializable;

/**
 *
 * @author Pikacu
 */
public class Customer implements Serializable {
private int customerId=-1;
private String customerName;
private String contactPerson;
private String address;
private String city;
private String postCode;
private String country;

    public Customer() {
    }

    public Customer(int id,String customerName, String contactPerson, String address, String city, String postCode, String country) {
        this.customerId=id;
        this.customerName = customerName;
        this.contactPerson = contactPerson;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }
    
    
    public Customer(String customerName, String contactPerson, String address, String city, String postCode, String country) {
        this.customerName = customerName;
        this.contactPerson = contactPerson;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }

   

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerName=" + customerName + ", contactPerson=" + contactPerson + ", address=" + address + ", city=" + city + ", postCode=" + postCode + ", country=" + country + '}';
    }


}
