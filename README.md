# Java

Banuprakash C

Full Stack Architect, Corporate Trainer

Co-founder & CTO: Lucida Technologies Pvt Ltd., 

Email: banuprakashc@yahoo.co.in; banuprakash.cr@gmail.com

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/NCG_Java1

===================================

Softwares Required:
1)  openJDK 17
https://jdk.java.net/java-se-ri/17

2) IntelliJ Ultimate edition 
https://www.jetbrains.com/idea/download/?section=mac


3) MySQL on Docker

Install Docker Desktop

Docker steps:

```
a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i local-mysql bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

```

OOP

SOLID Design principle

S -> Single Responsibility
O --> Open Close Principle
CLosed for Change and Open for Extension
L --> Liskov Substitution Principle
Applied for Generalization and Specialization relationship
I --> Interface seggregation
D --> Dependecy Injection

Java?
Technology
Platform --> Java Runtime Environment
JRE --> JVM  + classloader

Compile time environment

Source Code ===> Compiler ---> Bytecode
Java Programming language --> javac --> bytecode
Kotlin --> kotlin compiler ---> bytecode
Groovy --> groovy compiler --> bytecode

ClassLoader:
findLoadedClass()
loadClass()  --> Classpath
findSystemClass()
defineClass() --> Convert bytecode to system specific data structure

```

public class Account {
    private double balance;

    public void deposit(double amt) {
        this.balance += amt;
    }

    public double getBalance() {
        return this.balance;
    }
}


public class AccountExample {
    public static void main(String args[]) {
        Account annaAccount = new Account(); (1)
        annaAccount.deposit(5000); (2)
        Account rogerAccount = new Account();
        rogerAccount.deposit(1200);
    }
}

annaAccount.deposit(5000);

deposit(annaAccount, 5000);

```

Relationship between Objects:
1) Generalization and Specialization [isA] --> Inheritance
2) Realization
3) Association
4) Uses A


Logical grouping of classes/object
com.adobe.<<prj>>.entity

1) entity / domain / model
com.adobe.<<prj>>.dao
2) DAO --> Data Access Object -- CRUD operations
AccountDao
TransactionDao
CustomerDao
com.adobe.<<prj>>.service
3) Service --> Facade on business and DAO
CustomerService
AccountService
transferFunds(Account fromAcc, Account toAcc, double amt)
4) Business class
5) UI / Client
6) Exception
7) Utility

```

Inheritance Code:
```
1)Product p = new Product();
p.isExpensive(); // valid

2) Product p = new Mobile(...); // up casting
p.isExpensive(); // valid ? --> call isExpensive() of Mobile --> dynamic binding
p.getConnectivity(); // fails

Mobile m = (Mobile) p; // down casting
m.getConnectivity(); //work
```

* Object is the root class; every class inherits from Object class
* extends keyword for specialization
* every instance method is virtual
* Java doesn't support multiple inheritance

```

public class Account {
    private double balance; // state, instance variable
    private static int count; //state of class

    public Account() {
        count++;
    }
    public void deposit(double amt) {
        this.balance += amt;
    }

    public double getBalance() {
        return this.balance;
    }

    public static int getCount() {
        return count;
    }
}

* How many instances of Account is created...

swethaAcc.getCount(); //10

rahulAcc.getCount(); //10

Account.getCount(); // 10
```

Realization relationship
A component will realize the behaviour specified by other component in order to communicate

interface ProductDao {
    void addProduct(Product p);
    Product getProduct(int id);
}

Why program to interface?
1) DESIGN
2) IMPLEMENTATION
3) INTEGRATION
4) TESTING
5) Loose Coupling code

Visibility:
private, public, protected and default
protected --> package + private and visbile to inherited class which can be in other package
* All members in a class are of default scope [package private]
Visbile within a package
* All members in a interface are public by default [ visible across packages]

Class.forName("java.util.Date");  // loads the class into JVM

Task based on Association:
```
Person class with --> name and weight
Lift / Elevator
    * stops
    * capacity 5 persons
    * people[] 
    * enterPerson(Person p);
    * exitPerson(Person p);
    * moveUp()
    * moveDown()

Rules: 
   * Max people
   * check stops and control moveUp() or moveDown()
   * At any point get the status of Lift [# no of people, floor]
```

Note on Exception:


Exception: any abnormal condition that arises during program execution
exceptions can be Error type or exception type


Error Type: abnormal condition which can't be resolved during program exection
StackOverflowError, OutOfMemoryError, ...

Exception type:
a) CheckedType of Exception
    generally occur due to reasons --> outside of JVM
    Compiler enforces us to handle it using try / catch
b) UncheckedType of exception
    issues within JVM
    Should be handled using conditional statement and not try/catch

==============

Data Containers [ java.util package]
* Array has to be the first choice for data container

Java Collection Framework
a) interfaces
b) implementation class
c) algorthim classes / utility classes

Comparable
Comparator

Generics

public class Rectangle<T extends Number> {
    T width;
    T breadth;
    
}


Rectangle<Integer> r1 = new Rectangle<>(4,5);
Rectangle<Double> r2 = new Rectangle<>(1.2, 4.5);
Rectangle<String> r3 = new Rectangle<>("A", "B");

```

Day 2

Java 8 --> FunctionalInterface
FunctionalInterface: interface for which only one method to be implemented

If we have FunctionalInterface we can use lambda expression instead of Anonymous class to instantiate.

```
    Anonymous class:
   Comparator<Product> nameComparator = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
    };

    Lambda:
      Comparator<Product> nameComp = (Product p1, Product p2) -> {
       return p1.getName().compareTo(p2.getName());
      }
    Comparator<Product> nameComp = (Product p1, Product p2) -> p1.getName().compareTo(p2.getName());

      Comparator<Product> nameComp = ( p1,  p2) -> p1.getName().compareTo(p2.getName());

```

HashCode:
1) similar objects should have same hashCode
2) possibility is objects which are not similar can also have same hashcode [ collision ]

List:
* ordered collection
* can have duplicate elements
* can be re-ordered [ sort, shuffle, reverse]
* get / add / remove from arbitrary position

Implementation classes for List:
1) ArrayList
2) LinkedList

3) Apache Collections
4) VAVR collection


HOF: High Order functions:
1) functions which accept function as argument
2) function returns a function

Intermediate functions:
1) filter ---> to get subset based on Predicate [ Predicate.java interface]
2) map --> to transform the data
3) skip
4) limit

Terminal function:
5) reduce --> to get aggregte [ sum , count, max, ..]
6) forEach --> iteration
7) collect 


https://rxmarbles.com/


Set:
* unique collection
* ordering is based on type of container
* can't be re-ordered
* no index based operation

HashSet uses hashCode() and equals()

Methods of Map:
1) put(key, value)
2) get(key): value
3) containsKey(key): boolean

=================================

Maven / Gradle

Maven is a build automation tool used primarily for Java projects. 

/*
    multi-line
*/

// single line

/**
JavaDoc Comments
this is for API users
*/

JDBC --> Java Database Connectivity --> Integration Library

JDBC provides interfaces, implementation classes are provided by database vendors

Step 1:
establish a database connection

Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

URL:
jdbc:oracle:thin:@12.2.44.11:1501:/emp_db

jdbc:mysql://15.11.45.1:3306/emp_db

Step 2: Send SQL statements [ DML ]
a) Statement
if SQL is fixed and same for all requests
select * from products
b) PreparedStatement
if SQL has IN parameter
select * from users where username = ? and password = ?
insert into products values (?, ?, ?, ?);

c) CallableStatement

to invoke stored procedures

call transaction(?,?)

Step 3:
return values can be int or ResultSet
int for insert, delete and update statements

Step 4:
close the connection

finally block 

try {

} catch(SQLException ex) {

} finally {
    con.close();
}


Docker is a platform designed to help developers build, share, and run container applications.

```
mysql>  create database NCG_JAVA;
mysql> use NCG_JAVA

mysql> create table products (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double, quantity int);


mysql> insert into products (name, price, quantity) values ('Wacom' , 4500.00, 100);

mysql> insert into products (name, price, quantity) values ('Reynold' , 40.00, 100);


mysql> select * from products;
```

Day 3:

Convert it into Web application

Mapping

/login       LoginServlet
/register   RegistrationServlet
/products   ProductServlet


http://server:port/products

Deployment descriptor --> web.xml 

```
<servlet>
    <servlet-name>productservlet</servlet-name>
    <servlet-class> pkg.ProductServlet</servlet-class>
</servlet>

<url-mapping>
      <servlet-name>productservlet</servlet-name>
      <url-pattern>/products</url-pattern>
</url-mapping>

HTTP Methods:
GET, POST, PUT, DELETE, PATCH ,..

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
    }
}
```
CRUD operation
GET --> READ
POST --> CREATE
PUT --> UPDATE
DELETE --> DELETE

Servlet Containers: Tomcat, Jetty , Netty


Run Maven Goals:
mvn jetty:run

========================================

Spring Framework 

--> provides lightweight container for building enterpise application.
--> dependency Injection --> InversionOfControl [ IoC ]
Spring Core module provides
* life cycle management of beans
[ any object managed by spring container is a bean]
* wires dependencies

Spring container can be created using xml or annotation as metadata.

```
    interface BookDao {
        void addBook(Book b);
    }

    public class BookDaoJdbcImpl implements BookDao {
        public   void addBook(Book b) { ...}
    }

     public class BookDaoFileImpl implements BookDao {
        public   void addBook(Book b) { ...}
    }

    public class AppService {
        private BookDao bookDao;

        public void setDao(BookDao dao) {
            this.bookDao = dao;
        }

        public void insert(Book b) {
            this.bookDao.addBook(b);
        }
    }

beans.xml
<bean id="jdbc" class="pkg.BookDaoJdbcImpl" />
<bean id="file" class="pkg.BookDaoFileImpl" />
<bean id="service" class="pkg.AppService" >
    <property name="dao" ref="jdbc" /> <!-- service.setDao(jdbc) -->
</bean>

ApplicationContext ctx = new ClasspathXmlApplicationContext("beans.xml");

AppService ser = ctx.getBean("service", AppService.class);

```

Annotations as metadata:
Spring creates instances of classes which has one of these annoations at class-level:
1) @Component
2) @Repository
https://github.com/spring-projects/spring-framework/blob/main/spring-jdbc/src/main/resources/org/springframework/jdbc/support/sql-error-codes.xml
3) @Service
4) @Controller
5) @RestController
6) @Configuration
7) @ControllerAdvice

Wiring can be done using:
1) @Autowired
2) @Inject
3) Constructor DI

ApplicationContext ctx = new AnnotationConfiglApplicationContext();
-------

Spring Boot framework --> framework on top of Spring Framework

Spring boot 3.x is on Spring Framework 6.x
Spring boot 2.x is on Spring Framework 5.x


Spring Boot is highly opiniated framework, lots of configurations comes out of the box,
it simplifies development
* if we are building application to use database;
 spring boot gives database connection pool

* for web application development; it gives embedded tomcat container

* for ORM; it configures Hibernate as ORM framework


@SpringBootApplication is 3 in one:
1) @Configuration
2) @ComponentScan
@ComponentScan(basePackage="com.adobe")
3) @EnableAutoConfiguration [ opiniated]

Spring Framework uses
1) JavaAssit
2) ByteBuddy

for Bytecode instrumentation

3) CGLib --> for Proxy object

Issue:
Could not autowire. There is more than one bean of 'BookDao' type.
Beans:
bookDaoFileImpl   (BookDaoFileImpl.java) bookDaoJdbcImpl   (BookDaoJdbcImpl.java) 

Solution 1:
```
use @Qualifier
@Autowired
@Qualifier("bookDaoFileImpl")
private BookDao bookDao;
```

Solution 2:
```
Make one of the as Primary
remove @Qualifier

@Repository
@Primary
public class BookDaoFileImpl implements BookDao{

@Repository
public class BookDaoJdbcImpl implements  BookDao{

```
Solution 3:
```
@ConditionalOnMissingBean

@Repository
@ConditionalOnMissingBean(name = "bookDaoJdbcImpl")
public class BookDaoFileImpl implements BookDao{
```

Solution 4:
using Profile
```
@Repository
@Profile("prod")
public class BookDaoJdbcImpl implements  BookDao{

@Repository
@Profile("dev")
public class BookDaoFileImpl implements BookDao{

application.properties
spring.profiles.active=prod

OR

java jar app.jar --spring.profiles.active=prod
```

Factory methods
* need to manage 3rd party objects in Spring Container
* 3rd party classes won't have any of the above 7 annotations

==========

Day 4

ORM Framework
Object Relational Mapping
ORM frameworks:
Hibernate, Toplink, KODO, JDO, OpenJPA

JPA is a specification for ORMs
Why ORMs?
1) Database independence.
2) Faster development. With ORM, engineers omit writing boilerplate SQL commands

```

@Configuration
public class AppConfig {

    // pool of db connection
    @Bean
    public DataSource getDataSource() {
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); //loads the jdbc driver
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/NCG_JAVA");
            cpds.setUser("root");
            cpds.setPassword("Welcome123");
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);
            return cpds;
        } catch (Exception ex) {
            ex.printStackTrace();
            return  null;
        }
    }

    @Bean
    public EntityManagerFactory getEmf(DataSource ds) {
        LocalContainerEntityManagerFactory emf = new LocalContainerEntityManagerFactory(ds);
        emf.setJpaVendor(new HibernateJpaVendor());
        emf.setPakagesToScan("com.adobe.prj.entity");
        ..
        return emf;

    }
}

@Repository
public class ProductDaoJdbcImpl implements ProductDao {
    @PersistenceContext
    EntityManager em;

    public void addProduct(Product p) {
        em.persist(p);
    }

    public Product getProduct(int id) {
        return em.findById(id, Product.class);
    }
}

```

https://docs.spring.io/spring-boot/appendix/application-properties/index.html

1) spring.jpa.hibernate.ddl-auto=update
create tables if not exist, if exists map to existing table, if required alter columns

2) spring.jpa.hibernate.ddl-auto=create
create tables on application start, drop tables when application terminates

3) spring.jpa.hibernate.ddl-auto=verify
map to existing table, can't create new ones or alter them

1 order has 4 items:
```
save:
orderDao.save(order);
itemDao.save(item1);
itemDao.save(item2);
itemDao.save(item3);
itemDao.save(item4);

delete:
orderDao.delete(order);
itemDao.delete(item1);
itemDao.delete(item2);
itemDao.delete(item3);
itemDao.delete(item4);

Cascade:
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="order_fk")
  private List<LineItem> items = new ArrayList<>();

save:
orderDao.save(order);
delete:
orderDao.delete(order);
```

EAGER Fetch and Lazy Loading
```
By default one-to-many is LAZY loading
LAZY loading:
Order order = orderDao.findById(1, Order.class);
select * from orders where id = 1;


EAGER loading:
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name="order_fk")
private List<LineItem> items = new ArrayList<>();
Order order = orderDao.findById(1, Order.class);
select * from orders where id = 1;
select * from items where order_fk = 1;
```

Default fetching strategies:
1) manyToOne --> EAGER fetch
2) oneToOne --> EAGER fetch
3) OneToMany --> LAZY loading
4) ManyToMany --> LAZY loading

=======

Task:

```
Vehicle Rental application

customers table is same;

vehicles
REG_NO | cost_per_day | fuel_type | type 


rentals
id | rent_from | rent_to | customer_fk | vehicle_fk



Steps:
1) insert customers
2) insert vehicles
3) rent a vehicle
id | rent_from  | rent_to | customer_fk         | vehicle_fk
1    4 JUL 2024   NULL      abc@gmail.com        DA 12 A 2345
2     4 JUL 2024    NULL    abc@gmail.com        KA 50 A 1214

4) return a vehicle
id | rent_from  | rent_to       | customer_fk         | vehicle_fk
1    4 JUL 2024   5 JUL 2024      abc@gmail.com        DA 12 A 2345


5) print rental cost of the vehicle

```
SELECT *
FROM vehicles v
WHERE 
    reg_no = 'DA23A9013'
    AND NOT EXISTS (
        SELECT 1
        FROM rentals r
        WHERE 
            r.vehicle_fk = v.reg_no
            AND '2024-03-27' <= r.rent_to_date
            AND '2024-03-30' >= r.rent_from_date
    )
```

Day 5:

```
@Entity
public class Employee {
    @Id
    String email;

    // bi-directional
    @OneToOne(mappedby = "employee")
    Laptop laptop;
}

@Entity
public class Laptop {
    @Id
    String serialNo;

    @OneToOne
    @JoinColumn(name="employee_fk")
    Employee employee;
}

employees
email | hire_date | first_name


laptop
serail_no | make | .... | employee_fk

----

class Customer {

    // bi-directional
    @OneToMany(mappedBy="customer")
    List<Order> orders  = new ArrayList<>();
    
}

class Order {

    @ManyToOne
    @JoinColumn(name="customer_fk")
    Customer customer;
}
```

ManyToMany is a rare thing

```
students

sid | name 

subjects

subid | name 

students_subjects [link table]

sid | subid  


changes to 

sid | subid | start_date | end_date

to add extra fields

Student 1 ---> *  StudentSubject * ---> 1  Subject

```

Building RESTful Webservices

* Resource: database table , files , printer

* Representation : state of the resource at any given point of time

* ContentNegotiation: serve representation in different format to the client based on client http request header
Accept: text/xml
or
Accept: application/json

or CSV, atom , RSS feed, ...

Charactersitics of RESTful
1) Uniform Resource Identifier

http://localhost:8080/api/products

2) Stateless
3) Cacheable
4) Layered

Resources --> Plural nouns
actions --> HTTP verbs

CRUD operations

GET --> READ
POST --> CREATE
PUT/ PATCH --> Update
DELETE -> DELETE

@Controller --> Traditional Web application --> Server Side Rendering [ server sends rendered view -> html / pdf]
@RestController ---> ContentNegotiationHandler --> server different formats of represetnation of data.

DispatcherServlet


ProductController.java

```
@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final OrderService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return service.addProduct(p);
    }
}


```

ContentNegotiationHandler

JSON --> Jackson [default], GSON , Jettison, Moxy

XML --> JAXB , Jackson XML format, ...



```
POST  http://localhost:8080/api/products
Content-type: application/json

{
    "name": "Oppo",
    "price": 24000.00,
    "quantity": 100
}
``

Install POSTMAN for testing RESTful Endpoints

PathParameter / --> based on ID @PathVariable
```
GET http://localhost:8080/api/products/4
http://localhost:8080/api/customers/raj@gmail.com/orders
```

QueryParameters ? --> filtered / subset of records
```
GET http://localhost:8080/api/products?category=mobile
GET http://localhost:8080/api/products?low=5000&high=20000
```
Testing:
```

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.CoreMatchers.*;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//@WebMvcTest(ProductController.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest(classes = ShopappApplication.class)
```

Task:
```
PUT http://localhost:8080/api/products/3
specifies that the product with id 3 has to be mutated
payload should contain new product data which is used to update
```

Validation Exceptions:
```

Resolved [org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument [0] in public com.adobe.orderapp.entity.Product com.adobe.orderapp.api.ProductController.addProduct(com.adobe.orderapp.entity.Product) with 3 errors: 

[Field error in object 'product' on field 'quantity': rejected value [0]; codes [Min.product.quantity,Min.quantity,Min.int,Min]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.quantity,quantity]; arguments []; default message [quantity],1]; 
default message [Quantity entered 0 has to be more than 1]] 

[Field error in object 'product' on field 'price': rejected value [0.5]; codes [Min.product.price,Min.price,Min.double,Min]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.price,price]; arguments []; default message [price],10]; 
default message [Price entered 0.5 has to be more than 10]] 

[Field error in object 'product' on field 'name': rejected value []; codes [NotBlank.product.name,NotBlank.name,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.name,name]; arguments []; 
default message [name]]; default message [Name is required]] ]

```

Documentation
1) RAML
https://raml.org/

2) openAPI --> Swagger
https://springdoc.org/

http://localhost:8080/swagger-ui/index.html

http://localhost:8080/v3/api-docs


pom.xml
ProductController.java
SwaggerConfig.java

==========

Spring has String to primitive data type conversions
String --> int
String --> double

http://localhost:8080/api/dateformat?date=12-10-2012

@RequestMapping(value = "/dateformat",method = RequestMethod.POST)
    public Date dateex(@DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam(value = "date")Date date) {        

Complete Vehicle Rental --> RESTful Web application
Change System date, instead explicitly rent based on provided dates
1) rentFrom, rentTo
2) just pass rentForm
3) later return it

Testing and Security

===================

Day 6

ManyToMany:
needs link table with only foreign keys, should not have any extra columns, if extra columns are required convert that into
oneToMany and ManyToOne by creating an extra assoction table
```
    1                   *                           1
Employee --->       EmployeeProject  <---        Project

movies_actors
mid | aid
```

Testing:
1) Unit Testing
2) Integration Testing
3) E2E testing
4) UAT


Unit Testing 
Unit testing is the process where you test the smallest functional unit of code.
Don't write main or client to test the code ==> needs assertions with data in console

TDD

public int getMax(int[] elems) {
    // code
}

Write a test for this method --> TCER TestCaseExpectedResult

TEST_ID  | DESCRIPTION | SAMPLE INPUT | EXPECTED RESULT | RESULT

* Test fails
* complete the method
* Run tests again until it passes

Unit Testing Framework --> JUnit <<default added by Spring boot>>/TestNG 


=======
Spring boot testing includes:
1) JUnit-Jupiter
2) jsonPath [ https://jsonpath.com/] $.phoneNumbers[0].type, $, $.firstName, ...
3) Hamcrest [https://hamcrest.org/JavaHamcrest/tutorial]
Collections
array - test an array’s elements against an array of matchers
hasEntry, hasKey, hasValue - test a map contains an entry, key or value
hasItem, hasItems - test a collection contains elements
hasItemInArray - test an array contains an element

4) Mockito --> Mocking dependency
Alternate we have : EasyMock, JMock, ...

static imports
```
package com.adobe.orderapp.util;

public class ArrayUtil {
    public static final double PI = 3.14159;

    public static int getMax(int[] elems) {
        int max = elems[0];
        for(int elem : elems) {
            if(elem > max) {
                max = elem;
            }
        }
        return  max;
    }

    public static void sort(int[] elems) {
        for (int i = 0; i < elems.length; i++) {
            for (int j = i+1; j < elems.length; j++) {
                if(elems[i] > elems[j]) {
                    int swap = elems[i];
                    elems[i] = elems[j];
                    elems[j] = swap;
                }
            }
        }
    }
}


other class

import static pkg.ArrayUtil.PI;
public class SomeClass {

}

```

In mini project at least Controllers has to be tested --> 50%

No need to test Service classes.

java/main/resourcs/schema.sql
java/main/resourcs/data.sql

Whenever Spring boot application starts
spring.sql.init.mode=always
1) executes schema.sql --> contains DDL like create, alter, drop
2) data.sql --> contains DML --> INSERT, DELETE , UPDATE --> to populate the data

==================

Spring Security

Authentication and Authorization

```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
</dependency>
``

By adding above dependency all resources are protected, creates login and logout pages,
creates one user with username ="user" and password=<<generated>>

Using generated security password: 263db8f9-3207-40d6-85b8-c9bf01756b0a
http://localhost:8080/logout


InMemory    Jdbc        Ldap

   protected void successfulAuthentication(HttpServletRequest request, 
   HttpServletResponse response, FilterChain chain, 
   Authentication authResult) throws IOException, ServletException {
 
ConversationalState of client is managed used JESSIONID

JWT --> JSON Web Token

RESTful has to be Stateless. no to JSESSIONID

Why?
1) not all clients knows how to handle cookies
2) difficult when we configure clusters

```
jwt token:
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.
SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

Header:
{
  "alg": "HS256",
  "typ": "JWT"
}

Payload:
{
    "sub": "anna@gmail.com",
    "iat": 989328232,
    "exp": 999999999,
    "iss": "https://secure.adobe.com",
    "authorities": "ADMIN","GUEST"
}

SIGNATURE:
HMACSHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  topsecretsaltvaluetobeused
)

Keytool / OpenSSL
Private Key --> to generate token
public key --> to validate token
```
JWT:
```
   <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.5</version>
        </dependency>
```

Code:
entities:
1) User --> Role
dto:
1) SignUpRequest --> Registration
2) SigninRequest --> login
3) JwtAuthenticationResponse --> sending token

service:
1) UserDetailsServiceImpl -->  instance of UserDetailsService --> to find user based on Email
2) JwtService --> generate and validate token
3) AuthenticationService --> register and login

api
1) AuthenticationController --> login and register
2) JwtAuthenticationFilter --> added along with existing UsernamePasswordAuthenticationFilter

cfg:
SecurityConfiguration


Http Header
Authorization: Bearer <<token>>


