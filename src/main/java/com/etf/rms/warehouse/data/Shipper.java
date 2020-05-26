/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.data;

import java.io.Serializable;

/**
 *
 * @author Pavle Bradic 
 */
public class Shipper implements Serializable {
    
    private int shipperId=-1;
    private String shipperName;
    private String Phone;
    
    
    public Shipper(){
    }
    
    public Shipper(int shipperId,String shipperName,String phone){
        this.shipperId = shipperId;
        this.shipperName=shipperName;
        this.Phone=phone;
    }
    
    public Shipper(String shipperName,String phone){
        this.shipperName=shipperName;
        this.Phone=phone;
    }


  

   

    

    public void setShipperIid(int shippers_id) {
        this.shipperId = shippers_id;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getShipperId() {
        return shipperId;
    }

    public String getShipperName() {
        return shipperName;
    }

    public String getPhone() {
        return Phone;
    }

    @Override
    public String toString() {
        return "Shippers{" + "shipperId=" + shipperId + ", shipperName=" + shipperName + ", Phone=" + Phone + '}';
    }
    
    
    
}
