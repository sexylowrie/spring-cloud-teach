## What is Eureka?

Eureka is a REST (Representational State Transfer) based service that is primarily used in the AWS cloud for locating services for the purpose of load balancing and failover of middle-tier servers. We call this service, the **Eureka Server**. Eureka also comes with a Java-based client component,the **Eureka Client**, which makes interactions with the service much easier. The client also has a built-in load balancer that does basic round-robin load balancing. At Netflix, a much more sophisticated load balancer wraps Eureka to provide weighted load balancing based on several factors like traffic, resource usage, error conditions etc to provide superior resiliency.

## What is the need for Eureka?

In AWS cloud, because of its inherent nature, servers come and go. Unlike the traditional load balancers which work with servers with well known IP addresses and host names, in AWS, load balancing requires much more sophistication in registering and de-registering servers with load balancer on the fly. Since AWS does not yet provide a middle tier load balancer, Eureka fills a big gap in the area of mid-tier load balancing.

## How is Eureka used at Netflix?

At Netflix, Eureka is used for the following purposes apart from playing a critical part in mid-tier load balancing.

* For red/black deployments with Netflix [Asgard](https://github.com/Netflix/asgard)- an open source service which makes cloud deployment easier. Eureka interacts with Asgard to make switching between older/newer release of a deployment of services quick and seamless in case of problems - especially given that launching 100's of instances to deploy a release could take a long time.

* For our [cassandra](https://github.com/Netflix/Priam) deployments to take instances out of traffic for maintenance.

* For our memcached caching services to identify the list of nodes in the ring.

* Used for carrying other additional application specific metadata about services for various other reasons.

## When should I use Eureka?

You typically run in the AWS cloud and you have a host of middle tier services which you do not want to register with AWS ELB or expose traffic from outside world. You are either looking for a simple round-robin load balancing solution or are willing to write your own wrapper around Eureka based on your load balancing need. You do not have the need for sticky sessions and load session data in an external cache such as memcached. More importantly, if your architecture fits the model where a client based load balancer is favored, Eureka is well positioned to fit that usage.

## How does the application client and application server communicate? 

The communication technology could be anything you like. Eureka helps you find the information about the services you would want to communicate with but does not impose any restrictions on the protocol or method of communication. For instance, you can use Eureka to obtain the target server address and use protocols such as thrift, http(s) or any other RPC mechanisms.

## High level architecture

![Eureka High level Architecture](https://github.com/Netflix/eureka/raw/master/images/eureka_architecture.png)

The architecture above depicts how Eureka is deployed at Netflix and this is how you would typically run it. There is  **one** eureka cluster per **region** which knows only about instances in its region. There is at the least **one** eureka server per **zone** to handle zone failures.

Services **register** with Eureka and then send **heartbeats** to renew their leases every 30 seconds. If the client cannot renew the lease for a few times, it is taken out of the server registry in about 90 seconds. The registration information and the renewals are replicated to all the eureka nodes in the cluster. The clients from any zone can look up the **registry** information (happens every 30 seconds) to locate their services (which could be in any zone) and make remote calls.

## Configurability

With Eureka you can add or remove cluster nodes on the fly. You can tune the internal configurations from timeouts to thread pools. Eureka uses [archaius](https://github.com/Netflix/archaius) and if you had a configuration source implementation a lot of these configurations can be tuned dynamically.

## Resilience

Being in the AWS cloud, it is hard to not think about resiliency in everything we build. Eureka benefits from this experience we gained, with the resiliency built into both the client and the servers.

Eureka clients are built to handle the failure of one or more Eureka servers. Since Eureka clients have the registry cache information in them, they can operate reasonably well, even when all of the eureka servers go down.

Eureka Servers are resilient to other eureka peers going down. Even during a network partition between the clients and servers, the servers have built-in resiliency to prevent a large scale outage.
