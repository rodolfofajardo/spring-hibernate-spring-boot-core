# Spring Boot and Hibernate Udemy Training
## 2 Spring Boot - Spring Demo
### inversion of Control
The approach of outsourcing the construction
and management of objects
### Spring Container Primary Functions
- Create and manage objects (Inversion
of Control, IoC)
- Inject object dependencies (Dependency
Injection)
### Configuration Spring Container
- XML Configuration (legacy)
- Java Annotations (modern)
- Java Source Code (modern)
### Dependency Injection (Principle)
The client delegates to another object
the responsibility of providing its 
dependencies
### Injection Types
There are multiple types of injection
in Spring, the two recommended ones are:
- Constructor Injection
  - Used for required dependencies
  - recommended as first choice
- Setter Injection
  - Used for optional dependencies
  - If dependency is not provided, 
the app can provide reasonable default
logic
### AutoWiring
Spring can use AutoWiring for dependency
injection. It will search for the classes
by type (class or interface) and then Spring
will inject the class automatically.

@Autowired annotation tells Spring to
inject a dependency

@Component annotation marks a class as
a Spring Bean (Regular Java class 
managed by Spring) and makes it
available for injection

### First Commit: Constructor Injection
For this example:
1. we create an interface (Coach) 
with a method.
2. The interface is implemented in a class
   (CricketCoach) which is annotated
  with @Component
3. Then we create a Controller (DemoController)
where the Coach is injected via the
constructor, using the annotation 
@Autowired

Spring makes the injection possible
### Second Commit: Component Scanning
Spring scans Java classes for special
annotations, like @Component, and registers
them in the Spring Container.

This annotation in the main Application,
created by th initializr:
```
import org.springframework.boot.autoconfigure.SpringBootApplication;
```
enables Auto Configuration, Component
Scanning and Additional Configuration,
as it is composed by @EnableConfiguration,
@ComponentScan and @Configuration
annotations.

By default, Spring Boot starts component 
scanning from same package as the main 
Spring Boot application and also scans 
sub-packages recursively.

In order to scan other packages, they 
need to be listed in the @SpringBootApplication
annotation:
```java
@SpringBootApplication(
    scanBasePackages={"com.ixns.springcoredemo",
                      "com.ixns.util"})
public class SpringCoreDemoApplication {
  ...
}
```
### Third Commit: Setter Injection
Dependency Injection is done via the
setter methods.
```java
@RestController
public class DemoController {
  private Coach myCoach;
  @Autowired
  public void setCoach(Coach theCoach) {
    myCoach = theCoach;
  }
... 
}
```
### Field Injection
Injecting dependencies by setting field 
values on the class directly.

This type of injection was very popular
but is no longer recommended.
```java
@RestController
public class DemoController {
  @Autowired
  private Coach myCoach;
  // no need for constructors or setters
  ...
}
```
### Fourth Commit: Qualifiers
The @Qualifier annotation is used with
the name of a class when more than one
implementation matches a given type.

In the example, there is an interface
(Coach), which is implemented in 
four different classes (CricketCoach,
BaseballCoach, TrackCoach and
TennisCoach), all of them annotated
with @Component.

To inject one class in the controller
the @Qualifier annotation is used:
```java
@RestController
public class DemoController {
    private Coach myCoach;
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        myCoach = theCoach;
    }
  ...
}
```
Notice the name of the class is in 
lower camel case.
### Fifth Commit: Primary
An alternative to @Qualifier annotation,
in order to select only one implementation
the selected class will be marked with
the @Primary annotation.
```java
@Component
@Primary
public class TrackCoach implements Coach {
  ...
}
```
If more than one implementation is
annotated with @Primary, the application
will not start.

In case @Qualifier and @Primary
annotations are present, @Qualifier
takes precedence.
### Sixth Commit: Lazy Initialization
By default, when the application starts,
all beans are initialized.

Lazy initialization makes a bean to be
initialized only when it is needed.

To make a bean Lazy Initialized, it
needs to be marked with the @Lazy
annotation.
```java
@Component
@Lazy
public class TrackCoach implements Coach {
  ...
}
```
To make all beans Lazy Initialized,
add the following line to the
application.properties file:
```properties
 spring.main.lazy-initialization=true
```
### Seventh Commit: Bean Scopes
* __Singleton__: It is the default scope. 
Spring Container creates only one instance,
it is cached in memory and all 
dependency injections will reference
to the same bean.
* __Prototype__: Creates a new bean instance
for each request.
* __Request__: Only for web apps. HTTP Request
* __Session__: Only for web apps. HTTP Session
* __Global-Session__: Only for web apps. HTTP Global Session

In order to set a scope, it has to be
declared in the class with the @Scope
annotation:
```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach {
  ...
}
```




