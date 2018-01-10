# Working with DBs

## Spring core

Spring framework at it's core contains a configuration model, dependency injection mechanism and a container to run the application in. It came about in 2003 and as of v5.0 is compatible with JDK 8+ and JDK 9.

It has been developed to integrate with Java EE platform specifications, rather than wholly replace them. Current specifications include:
  - Servlet API
  - Websocket API
  - Concurrency Utilities
  - JSON Binding API
  - Bean Validation
  - JPA (Java Persistence API)
  - JMS (Java Message Service)
  - JTA/JCA setups for transaction coordination, if necessary

As well as supporting Java EE Dependency Injection and Common Annotations specifications.

Spring's core functionality is to take POJOs and configuration metadata, and assemble them into fully configured beans. 
Done with the `org.springframework.context.ApplicationContext` interface, the spring IoC (inversion of control) container.

![Container Magic](container-magic.png)	

## XML vs Java

Spring provides several ways to declare configuration metadata.
  - XML (OG)
  - Annotation-based (Spring 2.5)
  - Java-based (Spring 3.0)

### XML

Write XML files pointing to classes and declaring properties.
Use `ClassPathXmlApplicationContext` or `FilSystemXmlApplicationContext`.

*see\: `SpringXMLRunner.Java`*

### Annotations

Use annotations on POJOs (no longer POJOs) and use `context:component-scan` in your configuration to find them and construct the Application Context.

*see\: `SpringJavaRunner.Java`*


### Java-based

Create a configuration class(es), define beans and properties in there using annotations Use `AnnotationConfigApplicationContext` (takes any `@Component` or JSR-330 annotated class in constructor) to construct the Application Context

*see\: `SpringAnnotationsRunner.Java`*


## Autowiring

## JDBC & Driver

## Spring JDBC

## JPA2