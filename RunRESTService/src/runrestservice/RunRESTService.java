/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runrestservice;

import java.io.File;
import org.glassfish.embeddable.BootstrapProperties;
import org.glassfish.embeddable.CommandRunner;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;

/**
 *
 * @author steve
 */
public class RunRESTService {

    public static void main(String[] args) throws GlassFishException {
        
        BootstrapProperties bprops = new BootstrapProperties();
        GlassFishRuntime runtime = GlassFishRuntime.bootstrap();
        GlassFishProperties gfproperties = new GlassFishProperties();
        gfproperties.setPort("http-listener", 8081);
        GlassFish gf = runtime.newGlassFish(gfproperties);
        gf.start();  
        CommandRunner cr = gf.getCommandRunner();
        cr.run("set-hazelcast-configuration", "--enabled=true", "--dynamic=true");
        gf.getDeployer().deploy(new File("/opt/NetBeansProjects/JCacheWebinar/HazelcastWebinar/target/HazelcastWebinar-1.0.0-SNAPSHOT.war"));
    }
    
}
