# BitOftnOps : DevOps-bel-tounsi-mentorship-and-enrollment-microsiervices
the goal of this project is to implement "DevOps-bel-tounsi" a distributed system based on Event Driven architecture with kafka as a centralized distributed stream processing. 

## Project Architecture

![Alt text](https://github.com/tahanebti/devOps-bel-tounsi-mentorship-and-enrollment-microsiervices/blob/main/screenshoots/architecture-design.png)

## Description : 
This project is a work in progress. <br>
  1 - Currently working on Authentication, creating user acounts and permissions. (back & front)
  
## Patterns used :

### Microservices patterns

Config Server: A centralized configuration server is used to manage configuration data for the microservices, allowing for dynamic updates to configuration parameters without the need for a restart of the services.

Circuit Breaker: A circuit breaker pattern is used to protect the system from failures in downstream services, allowing the system to continue processing requests and fail gracefully in the event of a failure.

Load Balancer: A load balancer pattern is used to distribute incoming requests across multiple instances of a service, improving the system's scalability and fault tolerance.

Service Discovery: A service discovery pattern is used to allow microservices to discover and communicate with one another, enabling loose coupling between services and reducing the need for hard-coded service dependencies.

API Gateway: An API gateway pattern is used to provide a single point of entry for client requests, handling tasks such as request routing, request aggregation, and security enforcement.

Distributed Tracing: A distributed tracing pattern is used to capture and visualize the flow of requests across the system, allowing for easy debugging and performance analysis.

Fault Tolerance: A fault tolerance pattern is used to ensure that the system continues to operate even in the event of failures, including automatic recovery from failures, retrying failed requests, and handling partial failures.

### Transactional Pattern

Saga: A Saga pattern is used to ensure the correct execution of a sequence of transactions in a distributed system, in the case of user registration, the Saga pattern ensures that the correct steps are taken, such as sending a confirmation email, updating the user's information, and updating analytics data.

Outbox: An Outbox pattern is used to buffer events that are produced as part of a transaction and then publish them asynchronously after the transaction has been committed. This ensures that events are not lost even in the case of a failure, such as a crash of the event processing module.

Bulkhead: A Bulkhead pattern is used to isolate failures in one part of the system from affecting other parts of the system. For example, in the user registration scenario, the bulkhead pattern can be used to isolate the email notification service from the rest of the system, ensuring that a failure in the email service does not affect the ability of the system to persist the user's information or update analytics data.



## Technologies used
[Spring Cloud Stream](https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/) : to build highly scalable event-driven applications connected with shared messaging systems; <br>
[Spring Cloud Schema Registry](https://cloud.spring.io/spring-cloud-static/spring-cloud-schema-registry/current/reference/html/spring-cloud-schema-registry.htm) : that supports schema evolution so that the data can be evolved over time; besides, it lets you store schema information in a textual format (typically JSON) and makes that information accessible to various applications that need it to receive and send data in binary format; <br>
[Spring Data Elasticsearch](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html) : to persist data in elasticsearch
