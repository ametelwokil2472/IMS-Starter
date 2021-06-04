Coverage 91%

# Inventory Management System

The goal of this project was to build Inventory Management System application using a database backend to create, read, update and delete information about Items, customers, and orders. 
create an application using Java and SQL which interacts with a managed database. 

## Getting Started
### PrerequisitesSystem Requirements:
    *Java 1.8
    * Apache Maven
    *Git (For Version Control)
    

### Required Technologies
	* Version Control System: Git
    * Source Code Management: GitHub
    * Database Management System: MySQL Server 
	* Back-End Programming Language: Java
    * Build Tool: Maven
	* Unit Testing: JUnit
	
###	Installing

A step by step series of examples that tell you how to get a development env running

1. Clone the Main branch or Dev branch of this repository
2. After cloning this repo, open it up in your IDE
3. Go to `src/main/java/com/qa/ims/utils/DBUtils.java` you will need to modify the 'connect()' method with
    your own databse information
4. Run the 'Runner,java' class and the application should start and connect to your database 
	
## Running the tests

	Tests are in IMS-Starter\src\test\java
### Unit Tests
	Add the Mockito and Junit 5 dependencies in your pom file If you are using Eclipse, you will be able to run these tests by right-clicking the classes and selecting the "Run as JUnit test" option.
	Here are some images from the development process and some screenshots of the final application 

## Features 
## ER Model

 ![alt tag](https://github.com/ametelwokil2472/IMS-Starter/blob/master/src/main/resources/PNG.png)

 ## UML for Classes 
 
 ![alt tag](https://github.com/ametelwokil2472/IMS-Starter/blob/master/src/main/resources/UML%20Diagram.png)
 	   
## Features
	* Create Customers, read all customers, read one by id, update by id, delete by id
	* Create Items, read all Items, read one by id, update by id, delete by id
	* Create orders, read all orders, read one by id, update by id, delete by id
	* Create Order Item, read all orders, read one by id, update by id, delete by id


# Acknowledgments

 Thank you for stuff of QA Consulting 