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
public class Product implements Serializable{
    private int productId=-1;
    private String productName;
    private Supplier supplier;
    private String productCategory;
    private Double pricePerUnit;

    
    public Product(int productId,String productName, Supplier suplier, String productCategory, Double pricePerUnit) {
       this.productId=productId;
        this.productName = productName;
        this.supplier = suplier;
        this.productCategory = productCategory;
        this.pricePerUnit = pricePerUnit;
    }
    
    public Product(String productName, Supplier suplier, String productCategory, Double pricePerUnit) {
        this.productName = productName;
        this.supplier = suplier;
        this.productCategory = productCategory;
        this.pricePerUnit = pricePerUnit;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSuplier(Supplier suplier) {
        this.supplier = suplier;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "Producs{" + "productId=" + productId + ", productName=" + productName + ", suplier=" + supplier + ", productCategory=" + productCategory + ", pricePerUnit=" + pricePerUnit + '}';
    }
    
    
    
    
    
}
