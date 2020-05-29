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
public class Supplier implements Serializable {
    
     private int supplierId=-1;
     private String supplierName;
     private String contactPerson;
     private String address;
     private String city;
     private String postCode;
     private String country;
     private String phone;

     
      public Supplier(int supplierId,String supplierName, String contactPerson, String address, String city, String postCode, String country, String phone) {
     this.supplierId=supplierId;
          this.supplierName = supplierName;
        this.contactPerson = contactPerson;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.phone = phone;
    }
     
    public Supplier(String supplierName, String contactPerson, String address, String city, String postCode, String country, String phone) {
        this.supplierName = supplierName;
        this.contactPerson = contactPerson;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.phone = phone;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
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

    public String getPhone() {
        return phone;
    }

    public void setSupplierId(int supplier_Id) {
        this.supplierId = supplier_Id;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Suppliers{" + "supplierId=" + supplierId + ", supplierName=" + supplierName + ", contactPerson=" + contactPerson + ", address=" + address + ", city=" + city + ", postCode=" + postCode + ", country=" + country + ", phone=" + phone + '}';
    }
    
     
     
     
}
