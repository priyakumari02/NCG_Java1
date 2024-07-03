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

Resume @ 1:45
Database and Web application




