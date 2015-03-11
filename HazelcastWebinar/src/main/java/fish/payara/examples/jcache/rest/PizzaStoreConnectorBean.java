/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jcache.rest;

import fish.payara.examples.jcache.pizzaconnector.Customer;
import fish.payara.examples.jcache.pizzaconnector.Order;
import fish.payara.examples.jcache.pizzaconnector.PizzaStoreConnector;
import fish.payara.examples.jcache.pizzaconnector.PizzaStoreConnectorI;
import java.util.List;
import javax.cache.annotation.CacheResult;
import javax.enterprise.context.ApplicationScoped;


/**
 *
 * @author steve
 */
@ApplicationScoped
public class PizzaStoreConnectorBean implements PizzaStoreConnectorI {
    
    PizzaStoreConnectorI connectorImpl;

    public PizzaStoreConnectorBean() {
        connectorImpl = new PizzaStoreConnector();
    }

    @CacheResult
    public Customer getOrdersForCustomer(long customerID) {
        return connectorImpl.getOrdersForCustomer(customerID);
    }
    
    public Customer findCustomerById(long ID) {
        return connectorImpl.findCustomerById(ID);
    }
    
    public Order getOrderById(long ID) {
        return connectorImpl.getOrderById(ID);
    }
    
    public List<Long> getOrderIDsForCustomer(long custID) {
        return connectorImpl.getOrderIDsForCustomer(custID);
    }

    public void placeOrder(long customerID, long orderID, Order order) {
        connectorImpl.placeOrder(customerID, orderID, order);
    }

    public void cancelOrder(long orderID) {
        connectorImpl.cancelOrder(orderID);
    }

    public void createCustomer(long customerID, Customer customer) {
        connectorImpl.createCustomer(customerID, customer);
    }
    
    
    
}
