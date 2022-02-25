# Java Coding Challenge - Task Management API Suite

This is a maven project which uses an embedded derby database to store tasks in a table.

The table structure is provided below:

**Table name** - *tasks*

**Table columns:**
- *id* int not null generated always as identity,
- *title* varchar(256) not null,
- *description* varchar(1024),
- *due_date* date,
- *status* varchar(10),
- *creation_date* date not null,
- *primary key (id)*

Your challenge is to build a production grade API suite that uses HTTP to allow users to manage their task data. 

## Requirements

You will need to provide APIs for the following actions:  
 
1. Fetch all tasks.
1. Fetch all overdue tasks.
1. Fetch data for a single task.
1. Add a new task.
1. Modify a task.
1. Delete a task.


## Pre-requisites
1. Java needs to be installed on the system and environment variable JAVA_HOME should be set correctly to the JDK path.  
   Check by running below command in command prompt  
   `java -version`  
2. Maven needs to be installed on the system.  
   Check by running below command in command prompt  
   `mvn -v`  

## Run the application
This project uses Jetty as an embedded container to host the web application.  
Goto the base folder of the application and execute the following command to launch the application.  
`mvn spring-boot:run`  

The application will be available at [http://localhost:8080](http://localhost:8080)  

# The results.

I have re-implemented the skeleton using Spring boot rather than retain the original Servlet / database implementation.
You get a lot of stuff for free with Spring Boot. For example, I have implemented OpenAPI 3.0 and Swagger, although 
it is not entirely presentable.

I chose to re-implement it because what was originally given to me was disposable. If it were a legacy application, 
my approach would have been a lot different. I would have possibly used just the plain Servlet API with a JSON
parser, and then used possibly Hibernate, JDBCTemplate or plain JDBC to access the database. I would have pushed to 
upgrade to Java 15 for multi-line strings if JDBC was going to be the choice.

## TODO

* There are no tests. The framework is there.

* PUT, POST are still a bit wrong. 

* Responses with e.g. 404 include large stack traces.

* Dates are being converted to full microsecond-resolution timestamps.

* There is no authentication. Usually I use OAuth 2.0 code grant flow with PKCE. This is a lot of work and was not
  mentioned in the requirements.

* The Swagger UI is missing a lot of metadata and descriptions.

* I would not re-use the JPA Entities in the Controller. What the user sees and what goes in the database eventually
  diverge significantly.
  
* Caching (JPA, HTTP) is not configured. Monitoring and metrics not configured. Connection pools are not configured.
  But then again, we are only using Derby. 