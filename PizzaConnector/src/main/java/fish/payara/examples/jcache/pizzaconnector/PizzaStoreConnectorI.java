/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jcache.pizzaconnector;

import java.util.List;

/**
 *
 * @author steve
 */
public interface PizzaStoreConnectorI {

    public Customer findCustomerById(long ID);

    public Order getOrderById(long ID);

    public List<Long> getOrderIDsForCustomer(long custID);

    public Customer getOrdersForCustomer(long customerID);
    
    public void placeOrder(long customerID, long orderID, Order order);
    
    public void cancelOrder(long orderID);
    
    public void createCustomer(long customerID, Customer customer);
    
}
