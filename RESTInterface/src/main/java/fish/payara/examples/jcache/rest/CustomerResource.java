/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jcache.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import javax.enterprise.context.RequestScoped;
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
@Path("/customers/{customerid}")
@RequestScoped
public class CustomerResource {
    
    @Inject
    PizzaStoreConnectorBean connector;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }

    /**
     * Retrieves representation of an instance of fish.payara.examples.jcache.rest.CustomerResource
     * @param customerId
     * @return an instance of java.lang.String
     * @throws java.io.IOException
     */
    @GET
    @Produces("application/json")
    public String getCustomer(@PathParam("customerid") long customerId) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, connector.findCustomerById(customerId));
        return writer.toString();
    }
}

