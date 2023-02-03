# DevOps-bel-tounsi-mentorship-and-enrollment-microsiervices
the goal of this project is to implement "DevOps-bel-tounsi" a distributed system based on Event Driven architecture. 

== Technologies used

* https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/[`Spring Cloud Stream`] to build highly scalable event-driven applications connected with shared messaging systems;
* https://cloud.spring.io/spring-cloud-static/spring-cloud-schema-registry/current/reference/html/spring-cloud-schema-registry.html[`Spring Cloud Schema Registry`] that supports schema evolution so that the data can be evolved over time; besides, it lets you store schema information in a textual format (typically JSON) and makes that information accessible to various applications that need it to receive and send data in binary format;
* https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/[`Spring Data Elasticsearch`] to persist data in https://www.elastic.co/products/elasticsearch[`Elasticsearch`];
* https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/[`Spring Cloud OpenFeign`] to write web service clients easily;
* https://zipkin.io[`Zipkin`] to visualize traces between and within applications;
* https://github.com/Netflix/eureka[`Eureka`] as service registration and discovery.
