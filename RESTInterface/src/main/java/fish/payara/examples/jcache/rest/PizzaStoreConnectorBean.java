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

    //@CacheResult
    @Override
    public Customer getOrdersForCustomer(long customerID) {
        return connectorImpl.getOrdersForCustomer(customerID);
    }
    
    @Override
    public Customer findCustomerById(long ID) {
        return connectorImpl.findCustomerById(ID);
    }
    
    @Override
    public Order getOrderById(long ID) {
        return connectorImpl.getOrderById(ID);
    }
    
    @Override
    public List<Long> getOrderIDsForCustomer(long custID) {
        return connectorImpl.getOrderIDsForCustomer(custID);
    }

    @Override
    public void placeOrder(long customerID, long orderID, Order order) {
        connectorImpl.placeOrder(customerID, orderID, order);
    }

    @Override
    public void cancelOrder(long orderID) {
        connectorImpl.cancelOrder(orderID);
    }

    @Override
    public void createCustomer(long customerID, Customer customer) {
        connectorImpl.createCustomer(customerID, customer);
    }
    
}
