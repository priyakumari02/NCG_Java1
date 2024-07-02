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







