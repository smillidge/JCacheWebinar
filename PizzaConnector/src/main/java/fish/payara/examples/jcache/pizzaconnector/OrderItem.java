/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jcache.pizzaconnector;

import java.io.Serializable;

/**
 *
 * @author steve
 */
public class OrderItem implements Serializable {
    
    private Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    
    
    
}
