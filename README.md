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











