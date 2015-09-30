# JCacheWebinar
This example code is used in my presentations on JCache for Java One 2015

The application is built with maven and demonstrates the power of adding 12 characters to your code
```java
@CacheResult
```

Background
----------

The background to the presentation;

Imagine you work for an old fashioned Pizza Company. Your company has a website describing all your delicious Pizza Combos. 
However customers still have to phone in their orders as the Pizza Order Management system that automates Pizza creation
in your franchises is very old and seems to be connected to the world via damp string. You have been tasked with creating a
REST interface to enable the Web Wizards to create a fancy Javascript front end for mobile and web. You have been provided with
a library jar that does all the communications with the back end pizza order management system. 

Problem is calls over the damp string take many seconds to return and performance is awful.

JCache to the rescue!

Running the Project
-------------------

From the top level run
```shell
mvn clean install
```

Then from the Bootstrap Payara Micro drectory run
```shell
mvn exec:exec
```
This will run a Payara Micro instance. You can run this multiple times to fire up multiple Payara Micro servers.
Each Payara Micro Server will attempt to bind to port 8080 if there is something already running on that port it will try then next port up i.e. 8081

Once it is running you can access the customerorders resource using http://127.0.0.1:8080/PizzaService-1.0.0-SNAPSHOT/webresources/customerorders/1
This request should take around 20 seconds to execute every time it is accessed.

Now go to the source code of the PizzaStoreConnectorBean CDI bean uncomment the @CacheResult annotation (you will also have to add the import)
```java
    //@CacheResult
    @Override
    public Customer getOrdersForCustomer(long customerID) {
        return connectorImpl.getOrdersForCustomer(customerID);
    }
```

Once this is done. Rerun the test above and access the URL multiple times. This first time will be slow subsequent runs will be fast.
This is because the CacheResult annotation cached the result of the body of the method and on subsequent calls just returns the cached result rather than running the method body.

Now with the annotation active also run multiple Payara Micro instances. You should see the same fast response across all the other Payara Micro instances.
This is because the Cache is distributed across all the Payara Micro instances using the power of Hazelcast. 

The Project structure is 3 maven submodules.

PizzaConnector
--------------
This maven module build a jar that is supposed to represent a library provided by a 3rd party that connects to a legacy
Pizza Order Management System. This system has high latency and requests can take a number of seconds to execute. The
connector is also badly built so that multiple calls to the legacy system are required to fulfill a single request
often resulting in response times of many seconds. Latency is provided by simple sleep calls in the conntector library.

RESTInterface
-------------
This is the RESTful interface that developers have been asked to build so that the legacy
Pizza Order Management system can be exposed to the website and mobile applications.
This maven module builds a skinny war containing a number of REST services.

BootstrapPayaraMicro
--------------------
This maven module demonstrates how easy it is to Boot Payara Micro. Payara Micro is a lightweight Java EE runtime
ideal for running RESTful microservices. It is auto-clustering, using Hazelcast and autobinds to ports. It is fully embeddable in your code 
or can be run standalone directly using java. The boot code is just;
```java
    public static void main(String args[]) throws BootstrapException {
        PayaraMicro.getInstance()
                .setHttpAutoBind(true)
                .addDeployment("../RESTInterface/target/PizzaService-1.0.0-SNAPSHOT.war")
                .bootStrap();
    }
```
