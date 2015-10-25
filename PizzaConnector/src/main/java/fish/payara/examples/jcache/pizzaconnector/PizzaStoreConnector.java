/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jcache.pizzaconnector;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author steve
 */
public class PizzaStoreConnector implements PizzaStoreConnectorI {

    @Override
    public Customer getOrdersForCustomer(long customerID) {
        List<Order> result = new LinkedList<>();
        Customer customer = findCustomerById(customerID);
        List<Long> orderIDs = getOrderIDsForCustomer(customerID);
        for (Long orderID : orderIDs) {
            Order order = getOrderById(orderID);
            order.setDeliveryAddress(customer.getAddress());
            result.add(order);
        }
        customer.setOrders(result);
        return customer;
    }
    
    @Override
    public Customer findCustomerById(long ID) {
        sleepMs(2000);
        
        // CONSTRUCT DUMMY DATA
        
        Customer c = new Customer();
        c.setID(ID);
        
        if (ID == 1) {
            c.setFirstName("Sherlock");
            c.setLastName("Holmes");            
        } else if (ID == 2) {
            c.setFirstName("Doctor");
            c.setLastName("Watson");             
        } else {
            c.setFirstName("Mrs.");
            c.setLastName("Hudson"+ID); 
        }

        Address address = new Address();
        address.setHouseNameNumber("221B");
        address.setFirstLline("Baker Street");
        address.setSecondLine("Marylebone");
        address.setCity("London");
        address.setCountry("United Kingdom");
        address.setPostalCode("NW1 6XE");
        c.setAddress(address);
        return c;
    }
    
    @Override
    public Order getOrderById(long ID) {
        sleepMs(2000); 
        
        // CONSTRUCT DUMMY DATA
        
        Order result = new Order();
        result.setID(ID);
        Store store = new Store();
        Address storeAddress = new Address();
        storeAddress.setHouseNameNumber("Payara Pizza");
        storeAddress.setFirstLline("Payara House");
        storeAddress.setSecondLine("Marylebone");
        storeAddress.setCity("London");
        storeAddress.setPostalCode("NW1 6XE");
        storeAddress.setCountry("United Kingdom");
        store.setAddress(storeAddress);
        store.setStoreID(ID);
        
        Pizza pizza1 = new Pizza();
        pizza1.setName("Extra Hot Pepporoni");
        pizza1.setPrice(12.50);
        Pizza pizza2 = new Pizza();
        pizza2.setName("Smoked Mozarella and Mushroom");
        pizza2.setPrice(17.5);
        OrderItem pizza1oi = new OrderItem();
        pizza1oi.setPizza(pizza1);
        OrderItem pizza2oi = new OrderItem();
        pizza2oi.setPizza(pizza2);
        List<OrderItem> oitemlist = new LinkedList<>();
        oitemlist.add(pizza1oi);
        oitemlist.add(pizza2oi);
        result.setStore(store);
        result.setOrderItems(oitemlist);
        return result;
    }

    @Override
    public List<Long> getOrderIDsForCustomer(long custID) {

        
        // CONSTRUCT DUMMY DATA
        
        List<Long> result = new LinkedList<>();
        for (long i = 1; i <= 5; i++) {
            result.add(i);
        }
        return result;
    }

    @Override
    public void placeOrder(long customerID, long orderID, Order order) {
    }

    @Override
    public void cancelOrder(long orderID) {
    }

    @Override
    public void createCustomer(long customerID, Customer customer) {
    }
    
    private void sleepMs(int sleepingTimeMs) {
        try {
            Thread.sleep(sleepingTimeMs);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            Logger.getLogger(PizzaStoreConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
