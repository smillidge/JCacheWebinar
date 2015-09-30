/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jcache.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author steve
 */
@Path("/customerorders/{customerid}")
public class CustomerOrdersResource {
    
    @Inject
    PizzaStoreConnectorBean connector;

    /**
     * Creates a new instance of CustomerOrdersResource
     */
    public CustomerOrdersResource() {
    }

    /**
     * Retrieves representation of an instance of fish.payara.examples.jcache.rest.CustomerOrdersResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getOrders(@PathParam("customerid") long customerId) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, connector.getOrdersForCustomer(customerId));
        return writer.toString();
    }

}
