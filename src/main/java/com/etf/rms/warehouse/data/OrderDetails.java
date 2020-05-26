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
public class OrderDetails {
private int orderDetailsId=-1;
private Order order;
private Product product;
private int Quantity;  

    public OrderDetails() {
    }

     public OrderDetails(int orderDetailsId,Order order, Product product, int Quantity) {
        this.orderDetailsId=orderDetailsId;
         this.order = order;
        this.product = product;
        this.Quantity = Quantity;
    }
    
    public OrderDetails(Order order, Product product, int Quantity) {
        this.order = order;
        this.product = product;
        this.Quantity = Quantity;
    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setOrderDetailsId(int OrderDetailsId) {
        this.orderDetailsId = OrderDetailsId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "OrderDetailsId=" + orderDetailsId + ", Order=" + order + ", Product=" + product + ", Quantity=" + Quantity + '}';
    }


}
