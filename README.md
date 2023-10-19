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