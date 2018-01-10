# Working with DBs

## Spring core

Spring framework v5.0 compatible with JDK 8+ and JDK 9.
Spring core contains a configuration model and dependency injection mechanism.
It came about in 2003.
Integrates with Java EE platform specifications:
  - Servlet API
  - Websocket API
  - Concurrency Utilities
  - JSON Binding API
  - Bean Validation
  - JPA (Java Persistence API)
  - JMS (Java Message Service)
  - JTA/JCA setups for transaction coordination, if necessary

As well as supporting Java EE Dependency Inject and Common Annotations specifications.

Spring's core functionality is to take POJOs and configuration metadata, and assemble them into fully configured beans. 
Done with the `org.springframework.context.ApplicationContext` interface, the spring IoC (inversion of control) container.

![Container Magic](container-magic.png)	

## XML vs Java

Spring provides several ways to declare configuration metadata.
  - XML (OG)
  - Annotation-based (Spring 2.5)
  - Java-based (Spring 3.0)

### XML



## Autowiring

## JDBC & Driver

## Spring JDBC

## JPA2