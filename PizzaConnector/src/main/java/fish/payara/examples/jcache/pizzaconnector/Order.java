/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jcache.pizzaconnector;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author steve
 */
public class Order implements Serializable {
    
    private Address deliveryAddress;
    private Store store;
    private List<OrderItem> orderItems;
    private long ID;

    public double getPrice() {
        double result = 0.0;
        for (OrderItem item : orderItems) {
            result += item.getPizza().getPrice();
        }
        return result;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddres) {
        this.deliveryAddress = deliveryAddres;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    
    
}
