/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jcache.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author steve
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application{
    @Override

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;

    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(fish.payara.examples.jcache.rest.CustomerOrdersResource.class);
        resources.add(fish.payara.examples.jcache.rest.CustomerResource.class);
        resources.add(fish.payara.examples.jcache.rest.OrderResource.class);
    }
}
