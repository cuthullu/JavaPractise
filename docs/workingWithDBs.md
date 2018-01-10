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

Pros:
  - can be located on host file system and interpreted at runtime.
  - most mature and well documented 
  - leaves POJOs pure and unadulterated 
  - does not need Spring/DI dependencies (good for libraries)

Cons:
  - you have to write XML
  - easier for XML to become out of sync with POJOs


### Annotations

Use annotations on POJOs (no longer POJOs) and use `context:component-scan` in your configuration to find them and construct the Application Context.

*see\: `SpringJavaRunner.Java`*

Pros:
  - better IDE support
  - makes code easier to reason with (all information is together)
  - Can be written to Java EE annotation specifications (swap out your DI framework)
  - more succinct than XML
  
Cons:
  - code is tied to it's configuration once compiled
  - code is tied to it's Spring/other framework once compiled
  - DI definitions distributed and tightly coupled to logic



### Java-based

Create a configuration class(es), define beans and properties in there using annotations Use `AnnotationConfigApplicationContext` (takes any `@Component` or JSR-330 annotated class in constructor) to construct the Application Context.

*see\: `SpringAnnotationsRunner.Java`*

Pros: 
  - More complex/dynamic configurations possible, than with XML
  - Config can be decoupled from logic, split up and modularised
  - leaves POJOs pure and unadulterated
  - Better IDE support (than XML)

Cons:
  - Code needs to be recompiled to affect changes. 
  - More difficult to reason with logic
---

Each configuration method has it's pros and cons, and may be better suited for certain situations. Combinations of two or all three methods are entirely possible, though this may lead to spaghetti configurations and affect interoperability  



## Autowiring

## JDBC & Driver

## Spring JDBC

## JPA2