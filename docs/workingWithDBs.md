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

---

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

Autowiring searches a given path and attempts to *figure out* dependencies for you. The benefits of this is that it removes a lot of manual configuration and wiring up. The obvious down sides are that may not be exact, and to outside eyes, it will look like your code is held together by wishful thoughts and magic.

It is used by declaring your classes with one of the component annotations (`@Component, @Repository, @Service, @Controller`) and then using the `@Autowire` annotation where the instance of the component is to be used. Be it on properties, setters, or constructors, 

```
@Component
public class MyComponent {
    ...
}

public class ComponentUser {

  @Autowire
  private MyComponent myComponent;

}
```

If spring finds an ambiguous reference, it will throw a `NoUniqueBeanDefinitionException`. You can be more specific with autowiring by using `@Primary` to set one bean to be pick over others. Or you can use `@Qualifier` to specify a bean name. 


## JDBC & Driver

### JDBC

JDBC is an API for talking to SQL databases or tabular data sources  with Java. It broadly provides these functions:

- Establishing a connection to a database or data source
- Send SQL statements
- Process the results

Statements can created using the following three interfaces

#### `Statement` - *for executing a static SQL statement and returning the result.*

Statements are created through a `Connection` factory method, and provide three execution methods. 

```
Statement statement = conn.createStatement();
boolean canRetrieve = conn.execute("SELECT * from Users");
int rowsAffected = conn.executeUpdate("UPDATE Users set )
ResultSet rs = statement.executeQuery("SELECT * from Users");
```

By default a statement can only have one open `ResultSet` at a time. Therefore, any execution methods on a statement will close any existing open ResultSet. If multiple concurrent ResultSets are needed, then multiple statements should be instantiated. Statements do not support parameters.


#### `PreparedStatement` - *the statement is cached, so it can be efficiently repeatably called.*

PreparedStatements operate in much the same way as Statements, though they are cached and support parameters. 


```
PreparedStatement p = connection.prepareStatement("SELECT  * FROM user WHERE id > ?");

p.setInt(1, 100);
ResultSet rs = p.executeQuery();
```

#### `CallableStatement` - *for executing a stored procedure or function on the database*

```
String sql = "{call getUserEmail (?, ?)}";
CallableStatement c = connection.prepareCall(sql);
c.setInt(1, 104);
c.executeQuery();
String email = c.getString(2);
```

## Spring JDBC

| Action                                                   | Spring | You |
|----------------------------------------------------------|--------|-----|
| Define connection parameters.                            |        | x   |
| Open the connection.                                     | x      |     |
| Specify the SQL statement.                               |        | x   |
| Declare parameters and provide parameter values          |        | x   |
| Prepare and execute the statement.                       | x      |     |
| Set up the loop to iterate through the results (if any). | x      |     |
| Do the work for each iteration.                          |        | x   |
| Process any exception.                                   | x      |     |
| Handle transactions.                                     | x      |     |
| Close the connection, statement and resultset.           | x      |     |

## JPA2