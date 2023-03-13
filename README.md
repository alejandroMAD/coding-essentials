# Coding Essentials

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/alejandroMAD/coding-essentials/blob/main/README.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](https://github.com/alejandroMAD/coding-essentials/blob/main/README.es.md)

A bundle of three independent Java programming projects covering basic algorithms, OOP fundamentals, and database connectivity (JDBC) designed for first-year programming students to train themselves and pass their course.

Every exercise but the first—a mere play of imagination on objects— are the embryo of projects and applications with real practical utility, and I designed them with the intention that, in addition to allowing the training of your programming skills, they turn out to be interesting and entertaining.

<br>

## Table of Contents
1. [First exercise: Robots Lineage](#robots-lineage)
    1. [Required Knowledge](#lineage-knowledge)
    2. [Project Requirements](#lineage-requirements)
    3. [Console Output](#lineage-output)
    4. [Summary](#lineage-summary)
2. [Second Exercise: Yum Snack Bar](#yum-snack-bar)
    1. [Required Knowledge](#yum-knowledge)
    2. [Project Requirements](#yum-requirements)
    3. [Price Guide](#yum-price-guide)
    4. [Console Output](#yum-output)
3. [Third exercise: Filipinas Library](#filipinas-library)
    1. [Required Knowledge](#library-knowledge)
    2. [Project Requirements](#library-requirements)
    3. [Database Design](#library-design)
    4. [Database CREATE DDL statements](#library-db-creation)
    5. [Database INSERT-VALUES DML statements](#library-db-population)
    6. [Console Output](#library-output)
4. [Grade Course Curriculum](#grade-curriculum) 
5. [License](#license)

<br>

<h2 id="robots-lineage">
  1. First exercise: Robots Lineage
  <img src="https://github.githubassets.com/images/icons/emoji/unicode/1f916.png" alt="slot_machine" style="float:right;width:32px;height:32px;">
</h2>

<h3 id="lineage-knowledge">1.1 Required Knowledge:</h3>

* Creation of a console program in Java
* Use of Eclipse or another IDE
* Object-Oriented Programming
* Basic structures (variables, methods, constants, operators)
* Flow control (conditionals, loops)
* Visibility and encapsulation
* One-dimensional and two-dimensional arrays
* Enumerated types (Enum)
* Method overriding
* Method overloading / constructor overloading
* Inheritance and polymorphism
* Use of static and final
* Casting or type conversion
* Use of random functions

<h3 id="lineage-requirements">1.2 Project Requirements:</h3>

Write a program in the Java programming language, using Eclipse or another IDE, with several types of Robot classes to perform several types of calculations and activities to produce a console output as described in the following points:

1. Define an abstract superclass ```Robot``` that will serve as the basis for creating all robots. A ```Robot``` will always have a ```name``` and ```serialNumber```, both of type String. Create the necessary fields for the ```Robot``` class and a properly parameterized constructor.
2. The abstract superclass ```Robot``` will also have a static field ```robotCount``` to count how many objects of type ```Robot``` have been constructed. You must encapsulate these properties so they're not visible outside the class and define the appropriate _getters_ and _setters_ to retrieve or update the class variables, but don't make a setter for ```robotCount``` in order to prevent any external tampering of the construction counter behavior.
3. Add to the ```Robot``` class an override of the Object ```toString()``` method, which will return the following information: "I am a Robot of: [name=x, serialNumber=y]."
4. Create two abstract classes that inherit from ```Robot```, ```ArtsRobot``` and ```ScienceRobot```. Both classes will implement their own override of the ```toString()``` method, adding to the superclass' ```toString()``` method's output the addendum: ", discipline=Science]" or ", discipline=Arts]". Evaluate for these two classes the implementation of their own constructor in coordination with the ```Robot``` class constructor.
5. The ```ScienceRobot``` class will declare an abstract method ```process(double number)``` for implementation and use by the classes that inherit from it. The ```ArtsRobot``` class will define two constants ```REGULAR``` and ```RANDOM``` to define the behavior of the classes that inherit from it—consider declaring them in a Java enumerated type or Enum called ```Behavior```. ```ArtsRobot``` must provide two overloaded constructors, one that merely receives the ```name``` and ```serialNumber``` arguments and automatically assigns a ```REGULAR``` behavior to the arts robot, and a constructor that also specifies a third ```Behavior``` parameter, assigning the corresponding field to the specified behavior.
6. You must define two subtypes of ```ScienceRobot```, ```CuttingRobot``` and ```PrimeRobot```. These two subclasses cannot be inherited by any further sub-classes.
7. The ```PrimeRobot``` class offers two utilities: 1) Its implementation of ```process(double number)``` evaluates whether the number passed as an argument is a prime number or not and returns a String with the answer. Prime numbers are those natural numbers that are only divisible by themselves and by 1. Consider introducing control logic that evaluates whether the number received as argument is negative or has decimals—cases in which a number cannot be a prime. 2) The second utility of ```PrimeRobot``` is a method to print all prime numbers that exist in an interval; This method—give it an appropriate name—defines two integers as parameters: the ```start``` and ```end``` of the interval.
8. The ```CuttingRobot``` class implements several overloaded ```process()``` methods with different signatures. One of these overwrites the abstract method defined by ```ScienceRobot``` and receives a double value as argument in order to separately print on console the integer part and the decimal part of the value. The class also defines a ```process(int number)``` method that simply returns the received value divided by 2 and a ```process(String string)``` method that divides the received string in two halves and separately prints them on the console. Optionally, you can create two additional ```process()``` methods that receive an array of integers and an array of strings as parameters, divide them in half, and print the resulting arrays on the console.
9. You must define two subtypes of ```ArtsRobot```, ```PainterRobot``` and ```PoetRobot```. These classes can't be inherited from any other subclasses.
10. ```PainterRobot``` must have two constructors consistent with those of its superclass ```ArtsRobot```: one that only receives the ```name``` and ```serialNumber``` as arguments, and another one that also receives a ```Behavior```. This class contains constant and static definitions of three geometric figures, ```SQUARE```, ```TRIANGLE```, and ```RHOMBUS``` (they can be included in an Enum type ```Figure```); a method ```draw(Figure figure, int height, char character)``` that prints on console any of the three figures made of a repetition of characters of the ```char``` value passed as an argument and a height in lines of console output according to the ```height``` passed as an argument. Examples:
    
<table align="center">
    <tr>
        <td align="center">
            <b>m</b>
            <br><b>mmm</b>
            <br><b>m</b>
        </td>
        <td align="left">
            <b>$</b>
            <br><b>$$</b>
            <br><b>$$$</b>
            <br><b>$$$$</b>
            <br><b>$$$$$</b>
        </td>
        <td align="center">
            <b>uuuu</b>
            <br><b>uuuu</b>
            <br><b>uuuu</b>
            <br><b>uuuu</b>            
        </td>
        <td align="center">
            <b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
        </td>
    </tr>
</table>

11. Consider using a switch-case structure in the ```draw()``` method of ```PainterRobot``` to determine which drawing will be performed, and the option of delegating the console printing loops for each drawing to specialized methods ```drawSquare()```, ```drawTriangle()```, and ```drawRhombus()```.
12. Objects of ```PainterRobot``` instantiated with a ```REGULAR``` ```Behavior``` will draw the exact figure with the height in console output lines and repetition character passed as arguments, while instances of ```PainterRobot``` with ```RANDOM``` ```Behavior``` will ignore the configuration parameters of ```draw()``` and randomly paint a figure with random height —maximum of 12 lines— and a random character. Consider restricting the characters to a specific range of ASCII characters, for example between codes 33-95 to avoid printing "invisible" figures.
13. The class ```PoetRobot``` contains three attributes of type String[] (string array), each of them with 4 lines of a different poem or song, and a String[][] (two-dimensional array) attribute that stores the three poems or songs. The class defines two overloaded constructors consistent with those of its superclass ```ArtsRobot``` and a single method ```recite()```. This method doesn't return anything but prints 4 stored verses on the console under the following rules: If the instance of ```PoetRobot``` has a ```REGULAR``` ```Behavior```, it will coherently print the 4 verses of the poem or song of one of the String[] arrays randomly chosen. If it has a ```RANDOM``` ```Behavior```, it will print 4 randomly chosen verses from any of the three poems or songs, so there will be a very small probability of printing 4 verses from the same poem in their proper order.
14. Finally, define a ```Main``` class with a ```main()``` method for instantiating one ```Robot``` of each type: a ```PrimeRobot```, a ```CuttingRobot```, a ```PainterRobot``` with ```REGULAR``` ```Behavior```, a ```PainterRobot``` with ```RANDOM``` ```Behavior```, a ```PoetRobot``` with ```REGULAR``` ```Behavior```, and a ```PoetRobot``` with ```RANDOM``` ```Behavior```. The main class will be also printing general information of each object using the ```toString()``` methods, and then invoking the methods of each object to test them in the program execution. The proposed order of tests is as follows:
     1. Print the String representation or information of the six objects.
     2. Ask a ```PrimeRobot``` to process the number 11 to determine if it is a prime number.
     3. Ask a ```PrimeRobot``` to print all the prime numbers in the interval between 1 and 50..
     4. Ask a ```PainterRobot``` with ```REGULAR``` ```Behavior``` to draw a ```TRIANGLE``` of 8 lines high made up of '$' characters.
     5. Ask a ```PainterRobot``` with ```RANDOM``` ```Behavior``` to print a figure with any arguments: the robot will draw a figure randomly.
     6. Ask a ```CuttingRobot``` to process the number 4.0 and the number 0.285714.
     7. Ask a ```CuttingRobot``` to process the String "acurruca", process the integer array {5, 5, 45, 66, 1001, 2, 3, 11}, and also process the String array {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"}.
     8. Ask a ```PoetRobot``` with ```REGULAR``` ```Behavior``` to recite verses from its store.
     9. Ask a ```PoetRobot``` with ```RANDOM``` ```Behavior``` to recite verses from its store.
     10. Finally, print a message indicating the total number of Robots constructed.

<h3 id="lineage-output">1.3 Console Output:</h3>

```I am a Robot of: [name=Bender, serialNumber=1010011010BU22, discipline=Science]
I am a Robot of: [name=Euclid, serialNumber=E213002248G, discipline=Science]
I am a Robot of: [name=Frida, serialNumber=K15019071954L, discipline=Arts]
I am a Robot of: [name=Salvador, serialNumber=D1904858585A, discipline=Arts]
I am a Robot of: [name=Byron, serialNumber=E18091849AP, discipline=Arts]
I am a Robot of: [name=3DG4R-4LL4N-P03, serialNumber=E18091849AP, discipline=Arts]

+----------------------+
|     Operations     |
+----------------------+

11 is a prime number.

Primes between 1-50:
[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]

$
$$
$$$
$$$$
$$$$$
$$$$$$
$$$$$$$
$$$$$$$$

 G
GGG
 G

Whole part: 4; Decimal part: 0.0
Whole part: 0; Decimal part: 0.285714

acur / ruca
First half: [5, 5, 45, 66] / Second half: [1001, 2, 3, 11]
First half: [Mercurio, Venus, Tierra, Marte] / Second half: [Júpiter, Saturno, Urano, Neptuno]

3-1 Tu rencor, tu porqué, tu agonía...
3-2 O tal vez esa sombra
3-3 que se tumba a tu lado en la alfombra
3-4 A esperar que suba la marea.

1-4 Y no poder del árbol desasirse
2-1 ¿Qué es poesía?, dices mientras clavas
3-1 Tu rencor, tu porqué, tu agonía...
2-2 en mi pupila tu pupila azul.

=====Total robots manufactured: [6]=====
```

<h3 id="lineage-summary">1.4 Summary:</h3>

This program is intended to serve as a good example of object-oriented programming in Java. It uses abstract classes and inheritance to create a hierarchy of robot classes with different functionality.

The ```Robot``` class serves as the base class for all robots and contains common attributes like name and serial number, as well as a static counter to keep track of the number of robots created. The ```ArtsRobot``` and ```ScienceRobot``` classes are abstract classes that inherit from the superclass ```Robot``` and add functionality specific to their respective disciplines.

The ```PrimeRobot``` and ```CuttingRobot``` classes inherit from ```ScienceRobot``` and provide concrete implementations of the abstract ```process()``` method. Each of these robots serves a different purpose, such as checking whether a number is prime, dividing a number into its components or splitting a string in half.

The ```PoetRobot``` and ```PainterRobot``` classes inherit from ```ArtsRobot``` performing different operations. Their superclass ```ArtsRobot``` provides a ```Behavior``` attribute that is set to ```Behavior.REGULAR``` by default but can be overridden in the constructor. The ```PoetRobot``` class uses this attribute to generate poems with different levels of complexity, whereas the ```PainterRobot``` paints on the console geometric shapes made of characters with different rules depending on its ```Behavior```.

Overall, the program demonstrates how to use object-oriented programming concepts like inheritance and abstract classes to create a hierarchy of classes with different goals, making the code easier to maintain and extend.

<br>    

<h2 id="yum-snack-bar">
  2. Second exercise: Yum Snack Bar
  <img src="https://github.githubassets.com/images/icons/emoji/unicode/1f37f.png?v8" alt="popcorn" style="float:right;width:32px;height:32px;">
</h2>

<h3 id="yum-knowledge">2.1 Required Knowledge:</h3>

* Object-Oriented Programming
* Composition
* Modularization into packages and importing of classes
* Use of dynamic collections in Java
* Creation and handling of exceptions
* Creation and implementation of interfaces
* Java 8+ time and calendar API
* Information persistence: Java I/O API for reading/writing files
* Object comparison (_Comparable_)

<h3 id="yum-requirements">2.3 Project Requirements:</h3>

The goal of this exercise is to create a Java application to manage the activity of a movie theater snack bar business which sells different kinds of products such as popcorn, beverages and snacks. The main function is to register purchases or transactions, simulating a point-of-sale (POS) or cash register software.

The "Yum Snack Bar" establishment offers its customers the following products: 1) Soda soft drinks in different sizes; 2) Popcorn in different sizes; 3) Chocolates or snacks, 4) Bags of candies sold by weight; 5) Bags of assorted nuts that are also purchased by weight. 6) Menus consisting of a Popcorn box + Drink.

1. Build an Object-Oriented solution including the different classes necessary to organize the program, using packaging to divide the code as best as possible, grouping the classes by related characteristics and purpose.
2. The benefits of using inheritance to prevent redundances seem clear: for instance, it is possible to conceive a class ```PopcornBox``` and another class ```SodaCup``` with their own attributes, and a superclass ```Product``` with common attributes such as a ```name``` and ```price```.
3. Create constants defining the available sizes of the popcorn and drinks: ```MEDIUM```, ```LARGE```, ```EXTRALARGE```. A good approach could be defining an enumerated type (enum) ```Size```.
4. The different product classes must define the necessary ```toString()``` and _getter_ and _setter_ methods. The constructors of the classes and superclasses must be consistent with the project requirements. Keep in mind that this is an application for managing transactions, not for building the store and products. For this reason, the ```name``` and ```price``` of the objects won't be passed on instantiation, but they will already have a descriptive name and predefined price. It is advisable to use static fields for this purpose, in the absence of a proper product database. Use the double type to handle the ```price``` of the products.
5. Popcorn and drinks should have different prices depending on their size. The constructor of the ```SodaCup``` class, in addition to the ```Size```, will receive the ```SodaType``` (```COLA```, ```LIGHT_COLA```, ```ORANGE```, ```LEMON```) as argument for which the use of a class-nested enum type ```SodaType``` is advisable. There will be a class ```Menu``` that will allow the purchase of the combination of Popcorn + Drink at a promotional price. It is highly recommended to use composition to design this class, which will comprise instances of ```PopcornBox``` and ```SodaCup```.
6. <span id="yum-requirements-6">The constructor</span> of ```Menu``` will evaluate that the popcorn and beverage passed by argument are of the same ```Size```. Menus with a ```PopcornBox``` and a ```SodaCup``` of different size (e.g., ```PopcornBox``` ```MEDIUM``` and ```SodaCup``` ```LARGE```) are not allowed. Create a custom exception called ```IllegalSizeException``` that can be thrown in such cases.
7. The classes ```CandyBag``` and ```MixedNutsBag```, which allow purchase by weight, must define a static price with reference to 100 g of product, and their constructor will receive the specific weight of the purchase as argument. This amount is to be be multiplied by the ```price``` attribute to calculate a double ```totalPrice```. Create an interface called ```Measurable``` with a method ```calculatePrice(double weightOrAmount)``` to be implemented by these two classes of products that are sold in bulk. It is advisable to use some rounding function up to 2 decimal places toin order to avoid printing prices like 8.250000000000002.
8. <span id="yum-requirements-8">The classes</span> ```CandyBag``` and ```MixedNutsBag``` must incorporate include a logic to throw an ```IllegalArgumentException``` exception if an attempt is made to buy a bag with a negative or abnormally low ```price``` —less than 20 g— to prevent cheating with the scale.
9. The class ```Snack``` will be the simplest of all: it inherits from ```Product```, has a static ```price```, a static ```name``` of the product, and a constructor without any parameters.
10. <span id="yum-requirements-10">Create a class</span> ```Store``` that keeps the necessary information of the establishment that you consider necessary and, at a minimum, its ```name``` and the ```foundationDate``` of the snack kiosk. Use preferably one of the time-calendar classes in the Java 8+ API. You must create a method allowing to print a message on the console in the format: "Welcome to the Yum Snack Bar program. Serving popcorn, cholesterol, and joy for {x} years". The number of years must be calculated dynamically based on the predefined ```foundationDate``` of the store and its difference with the current system time when the program is executed.
11. Create a class ```Transaction``` to combine all the products purchased by a single customer in a cash operation (e.g., a customer buys a ```Menu```, a ```Snack```, and a ```CandyBag``` in a single ```Transaction```). A ```Transaction``` has attributes of an integer ```id```, the exact ```timestamp``` (date and time) of its creation, a List of products (use a dynamic collection such as a ```List<Product>```), and the ```totalCost``` of the products that make it up. Create the necessary methods in the ```Transaction``` class for the business logic, including ```toString()``` to display the string representation of its components on the console. Use the methods provided by the ```Product``` class to implement the logic.
12. <span id="yum-requirements-12">It is necessary to know</span> which is the most expensive ```Transaction``` —with the highest ```totalCost```— from a list of transactions. This goal can be achieved in various ways, but it is recommended to use the ```Comparable``` or ```Comparator``` interfaces for this purpose.
13. Define a class ```LogTransaction``` to store in a **log.txt** file the information of all the transactions of a program session and also capable of reading the information from the log and displaying it on the console. The format of the log and the implementation details are free, but to keep it simple it is recommended to save each ```Transaction``` on a new line, with a format like the following: 'date-time transaction-id, product, product, product: price.'
14. As an additional exercise, introduce in the ```LogTransaction``` class the necessary evaluation logic so that the most expensive ```Transaction``` ([point 12](#yum-requirements-12)) is saved in the file adding the string **(!)** to the end of its line.
15. Optionally, create a Java Swing GUI (graphical user interface) to make the flow of purchasing and storing transactions easy and intuitive for the user in a point-of-sale POS-fashion application.
16. In a main class, in the ```main()``` method, invoke the store's greeting phrase ([point 10](#yum-requirements-10)) and create successive sales of products and transactions to test the program. The operations to be performed in the main method are as follows:
    1.	Six different purchases of type ```Transaction``` will be sequentially instantiated in order to save them in a list, pass them into ```LogTransaction``` to save them in the log file, and then read that file and print its contents on the console.
    2. :heavy_check_mark: On the first transaction, purchase a ```LARGE``` ```PopcornBox``` and a ```Snack```, save the ```Transaction``` in the transaction list, and print it.
    3. :heavy_check_mark: On the second transaction, purchase a ```MEDIUM``` ```SodaCup``` and a ```MixedNutsBag``` of 400 g, save the transaction in the transaction list and print the transaction.
    4. :no_entry: On the third transaction, purchase a ```Menu``` made of an ```EXTRALARGE``` ```LIGHT_COLA``` ```SodaCup```, and a ```MEDIUM``` ```PopcornBox```, just to set off the throwing (and catching) of the ```IllegalSizeException``` ([point 6](#yum-requirements-6)). The exception should prevent this invalid ```Transaction``` from being saved, logged, or printed on the console.
    5. :no_entry: On the fourth transaction, cheat the scale to buy a 6 g ```CandyBag```, and set off the throwing of an ```IllegalArgumentException``` from [point 8](#yum-requirements-8). The exception should prevent this invalid ```Transaction``` from being saved, logged, or printed on the console.
    6. :heavy_check_mark: On the fifth transaction, purchase a 400 g ```CandyBag``` and a ```Menu``` made of an ```EXTRALARGE``` ```ORANGE``` ```SodaCup``` and an ```EXTRALARGE``` ```PopcornBox```. Try and instantiate the ```Transaction```, the ```Product``` objects, and the objects that make up the ```Menu``` in a single line of code (using _anonymous object instantiation_ or "on the fly" instantiation). Save the transaction and print it.
    7. :heavy_check_mark: On the sixth and most expensive transaction, purchase a ```CandyBag``` of 750 g and an ```EXTRALARGE``` ```COLA``` ```SodaCup```, save the ```Transaction``` and print it.
    8. :heavy_check_mark: Print on the console which ```Transaction``` was the most expensive of the entire session.
    9. :heavy_check_mark: Finally, save the list of transactions to the log file and retrieve the information that has just been saved in this file to print it on the console.

<h3 id="yum-price-guide">2.4 Price Guide:</h3>

The following price guide is recommended for the products in the store:

<br>

<table align="center">
    <tr>
        <th colspan=2, align="center">
            <b>Yum Snack Bar prices</b>
        </th>
    </tr>
    <tr>
        <th align="center">
            <b>Product</b>
        </th>
        <th align="center">
            <b>Price</b>
        </th>
    </tr>
    <tr>
        <td>
            PopcornBox MEDIUM / LARGE / EXTRALARGE
        </td>
        <td>
            5.0 / 7.0 / 9.0
        </td>
    </tr>
    <tr>
        <td>
            SodaCup MEDIUM / LARGE / EXTRALARGE
        </td>
        <td>
            4.5 / 6.0 / 7.5
        </td>
    </tr>
    <tr>
        <td>
            Menu MEDIUM / LARGE / EXTRALARGE
        </td>
        <td>
            7.95 / 8.95 / 9.95
        </td>
    </tr>
    <tr>
        <td>
            Snack
        </td>
        <td>
            2.0
        </td>
    </tr>
    <tr>
        <td>
            MixedNutsBag (100 g)
        </td>
        <td>
            1.80
        </td>
    </tr>
    <tr>
        <td>
            CandyBag (100 g)
        </td>
        <td>
            1.10
        </td>
    </tr>
</table>

<h3 id="yum-output">2.5 Console Output:</h3>

```+------------------------+
| Welcome to the Yum Snack Bar|
| Puerta del Sol, Km. 0, 28013 Madrid, Spain|
| Serving popcorn, cholesterol, and joy for 37  years. |
+------------------------+

Transaction [ID=1,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Popcorn box 'LARGE' - price=7.0], Product: 'Chocolate snack' - price=2.0],
	totalCost=9.0]
	
Transaction [ID=2,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Soda beverage cup 'MEDIUM' - price=4.5], Product: 'Mixed nuts bag' - price=7.2],
	totalCost=11.7]
	
products.IllegalSizeException: Soda cup and popcorn box must be of the same size.
	at products.Menu.<init>(Menu.java:16)
	at store.Main.main(Main.java:42)
	
java.lang.IllegalArgumentException: CandyBag weight must be 20g or higher
	at products.CandyBag.<init>(CandyBag.java:18)
	at store.Main.main(Main.java:55)
	
Transaction [ID=5,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Product: 'Gummy candy bag' - price=4.4, Menu: Soda+Popcorn 'EXTRALARGE' - price=9.95],
	totalCost=14.35]
	
Transaction [ID=6,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Product: 'Gummy candy bag' - price=8.25, Soda beverage cup 'EXTRALARGE' - price=7.5]],
	totalCost=15.75]

The most expensive transaction (!) is:

Transaction [ID=6,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Product: 'Gummy candy bag' - price=8.25, Soda beverage cup 'EXTRALARGE' - price=7.5]],
	totalCost=15.75]

==== Transactions in the log file ====

15/02/2023-15:00:33 ID=1, Popcorn box, Chocolate snack; price=9.0
15/02/2023-15:00:33 ID=2, Soda beverage cup, Mixed nuts bag; price=11.7
15/02/2023-15:00:33 ID=5, Gummy candy bag, Soda cup + Popcorn box at menu price; price=14.35
15/02/2023-15:00:33 ID=6, Gummy candy bag, Soda beverage cup; price=15.75 (!)
```

<br>

<h2 id="filipinas-library">
  3. Third exercise: Filipinas Library
  <img src="https://github.githubassets.com/images/icons/emoji/unicode/1f4da.png?v8" alt="books" style="float:right;width:32px;height:32px;">
</h2>

<h3 id="library-knowledge">3.1 Required Knowledge:</h3>

* Object-Oriented Programming in Java (composition and other techniques)
* Collections API in Java
* Classes and interfaces of the Java JDBC API
* Relational databases: concepts and structure
* MySQL language (DDL, DML, DQL)
* Installation of a local MySQL server (e.g. phpMyAdmin)
* Download of an appropriate JDBC driver and installation in the project's classpath
* Informal object-relational mapping (without using an ORM framework)
* Basic CRUD in MySQL
* Use of Prepared Statements
* Resource closing to avoid memory leaks (option to use the try-with-resources syntax)
* Exception handling
* Best practices in code writing

<h3 id="library-requirements">3.2 Project Requirements:</h3>

The goal of this exercise is to create a Java program with practical utility capable of managing the book borrowing service of a public library. The application performs queries and updates to a MySQL database whose creation and data insertion statements are provided below.

The database stores information in four tables: ```library``` to keep general information and rules of the library; ```book``` containing information about the books in the library's collection and their availability; ```reader``` containing information about the readers or users of the library's borrowing service; and ```borrowing``` with information about book loans to readers, which includes foreign keys referencing the ```book``` and ```reader``` tables.

It is important to be familiar with the **Library's Borrowing Rules** in order to develop the administration software consistently<sup>1</sup>. The default library designed in the SQL statements offered below implements the following rules regarding the maximum items allowed on borrowing, the period of borrowings and a penalty for overdue items, as it is customary of many public libraries in Spain, consisting of the suspension of borrowing privileges for a period of time.

<table align="center">
    <tr>
        <th colspan=2, align="center">
            <b>Filipinas Library Borrowing Rules</b>
        </th>
    </tr>
    <tr>
        <td>
            1.
        </td>
        <td>
            The library allows each user to have a maximum of 3 books borrowed at the same time.
        </td>
    </tr>
    <tr>
        <td>
            2.
        </td>
        <td>
            The library grants the borrowing of its items for a maximum period of 15 days.
        </td>
    </tr>
    <tr>
        <td>
            3.
        </td>
        <td>
            The library will impose a penalty for readers with books overdue consisting of a suspension of borrowing privileges of 3 days for each day of delay in returning a book (e.g. a delay of 5 days results in a penalty of 15 days of suspension).
        </td>
    </tr>
</table>

Taking these requirements into account, create a Java program with the following specifications:

1. Create a project that includes the necessary driver in the classpath to manage a **MySQL database** and define in the Java program the path, credentials, and other values necessary to establish a connection with a local server.
2. Create the database and insert the values provided below into a local MySQL server (you can use XAMPP-phpMyAdmin or MySQL Workbench). The sample records provided offer a variety of cases to test the program you are developing, including loans dynamically created on dates relative to the system date at the time of data insertion.
3. Create the necessary classes in your Java project to provide an object-oriented solution with a convenient modularity. Therefore, the application should have "model" classes equivalent to the entities in the database: ```Library```, ```Book```, ```Reader```, and ```Borrowing```, with properties corresponding to the fields in the database tables. It is recommended to divide the code into classes and packages following an MVC design pattern or similar modular architectures.
4. The library management software could provide many functions such as CRUD operations for books and subscribed readers, listing borrowings and returns, searching, comparisons with advanced filters, etc. However, in this exercise, you should only code the functionality necessary to approve item loans to readers and record returns of books. Although these two operations may seem simple, implementing them properly according to the rules described at the beginning will require making queries and perform checks in the four tables.
5. The application will prompt the user with a console menu, in an infinite loop, to entenr the operation they want to perform — ```BORROW```, ```RETURN```, or ```EXIT``` — and then will request the values ```bookId``` and ```readerId``` to carry out the selected operation, if it is possible to perform, using specialized methods.
6. You must pay special attention so the application, to carry out borrowings and returns, assess books, readers and borrowing situations according to the rules of the library: the maximum number of borrowings, the maximum borrowing period, the penalty days for each day overdue in ongoing borrowings, the number of borrowings a reader currently holds, whether the reader has a registered penalty, the availability value of a book to know if it is currently borrowed or not, etcetera.
7. A particular case you must control consists of attempts to return a book that is currently borrowed to a user by a different user. If this was allowed, although the change in the book's availability would be registered correctly, the system would welcome the undesirable case where a reader's number of borrowed books could be decreased even to negative values, disrupting the library's operation rules. To prevent this, the method that handles the returns must check that there is a borrowing of the specified ```bookId``` to the specified ```readerId``` and that the borrowing is still valid (the ```returnDate``` is null).
8. <span id="library-requirements-8">OPTIONAL:</span> You can try to implement the most complex logic in the application and make it check the days a reader is overdue in returning books that they still have borrowed. The program: 
    1. Will prevent the reader from borrowing new books if they are overdue in any of their current borrowings.
    2. Calculate and register the appropriate penalty by adding it to the value of the ```penalty_count``` field in their ```reader``` table record and the ```overdue_penalty``` field of that borrowing record in the ```borrowing``` table at the time of return.
10. OPTIONAL: Create a graphical user interface with Java Swing or another framework to facilitate the management of book borrowings and returns in a graphical environment.
11. OPTIONAL: Implement any other functionality that you consider interesting to the application.
12. TIP: To search for borrowings by their ```borrowingId``` in order to register a ```RETURN``` in the database, it is recommended to limit the query to the last result (```DESC LIMIT 1``` clause) to avoid any confusion with old borrowings of the same book to the same reader that could result in application bugs.
13. To test the application, an execution will be carried out by giving the following orders in the option selection menu:

    1. :heavy_check_mark: The first operation will consist of registering a ```BORROWING``` of the book with ID 1 ("Don Quixote") to the reader with ID 1 (George Stobbart). A confirmation message will be displayed, the ```available``` status of the book will be updated, and the counter of ```borrowed_books``` of this reader will be incremented by 1.
    2. :heavy_check_mark: The second operation will consist of carrying out the ```RETURN``` of the book with ID 3 ("The Adventures of Huckleberry Finn") borrowed by the reader with ID 1 (George Stobbart). This borrowing comes pre-constituted by the proposed insertions below, and is designed to be made on the same day of the data insertion at 08:34:05 hours. A confirmation of the return will be displayed, the ```available``` status of the book will be changed to true, the ```return_date``` will be inserted in the corresponding record of the ```borrowing``` table, and the counter of ```borrowed_books``` for the reader will be decreased by 1.
    3. :no_entry: The third operation will consist of trying to register a ```BORROWING``` of the book with ID 1 ("Don Quixote") to the reader with ID 6 (Liam McGuire); a message must be displayed indicating that it is not possible to approve the borrowing after verifying the book's unavailable status due to the test's first operation.
    4. :no_entry: The fourth operation will consist of trying to register a ```BORROWING``` of the book with ID 10 ("Life and Fate") to the reader with ID 4 (Augustin Rosso); a message must be displayed indicating that it is not possible to approve the borrowing because the reader already holds 3 books, the maximum number of borrowings allowed.
    5. :no_entry: The fifth operation will consist of trying to register a ```BORROWING``` of the book with ID 14 ("Les Misérables") to the reader with ID 15 (Gamal Khan); a message must be displayed indicating, despite the book being available, that it is not possible to authorize the loan because the reader has an overdue penalty.
    6. :no_entry: The sixth operation will consist of trying to register the ```RETURN``` of the book with ID 11 ("The Invention of Morel") by the reader with ID 9 (Pearl Henderson). This book is actually borrowed by the reader with ID 4 (Augustin Rosso), and therefore, the system must not authorize the operation, informing of this situation.
    7. :heavy_check_mark: The seventh operation will consist of registering the ```RETURN``` of the book with ID 9 ("The Hound of the Baskervilles") by the reader with ID 12 (François Plantard). The operation must be authorized, a confirmation message must be shown, and the necessary database update operations must be performed regarding the ```borrowed_books``` reader counter decrease, the ```return_date``` of the borrowing, and the ```available``` status of the returned book.
    8. :no_entry: **OPTIONAL**: The eighth operation, if the control logic of [optional point 8](#library-requirements-8) has been implemented, will consist of attempting to register the ```BORROWING``` of the book with ID 9 ("The Hound of the Baskervilles") returned by another reader, by the reader with ID 2 (Nicole Collard). This reader does not have a registered penalty yet, but has been holding the borrowing of two books for 19 and 17 days respectively according to the provided pre-constituted data, and she is therefore delayed in their return. Thus, the program must not allow the borrowing.
    9. :heavy_check_mark: **OPTIONAL**: The ninth operation, if the control logic of [optional point 8](#library-requirements-8) has been implemented, will consist of registering the ```RETURN``` of the book with ID 15 ("Metamorphosis") by the reader with ID 3 (André Lobineau), who is already 1 day overdue in their return. The operation must be authorized and the program is expected to update the database, including a penalty of 3 days for 1 day of delay in the reader's ```penalty_count```, in addition to modifying the fields of the book's ```available``` status, the borrowing's ```return_date```, and the ```borrowed_books``` counter of this reader.
    10. :heavy_check_mark: **OPTIONAL**: The tenth and eleventh operations, if the control logic of [optional point 8](#library-requirements-8) has been implemented, will consist of registering the ```RETURN``` of the books with ID 7 and 12 ("Robinson Crusoe" and "The Stand") by the reader with ID 2 (Nicole Collard). As they are overdue in their return by 4 and 2 days respectively, the program is expected to properly register and update the database ```return_date``` fields, setting a ```penalty_count``` of 12 + 6 = 18 days on the reader Nicole Collard.
    11. :heavy_check_mark: The last operation will consist of selecting the ```EXIT``` option, which should end the iterative execution and terminate the application. It is advisable to check the MySQL database on the server to see if the data in the ```book```, ```borrowing```, and ```reader``` tables has been updated according to the borrowings and returns invoked during this test.

<h3 id="library-design">3.3 Database Design:</h3>

![Database design](/library_design.png)
    
<h3 id="library-db-creation">3.4 Database DDL creation with CREATE statements:</h3>

```DROP DATABASE IF EXISTS filipinas_library;
CREATE DATABASE filipinas_library;
USE filipinas_library;

CREATE TABLE library (
    library_id INT AUTO_INCREMENT PRIMARY KEY,
    library_name VARCHAR(255),
    library_address VARCHAR(255),
    library_phone_number VARCHAR(20),
    max_borrowings INT DEFAULT 3,
    borrowing_period_days INT DEFAULT 15,
    late_return_penalty_days INT DEFAULT 3
);

CREATE TABLE book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    publication_year INT,
    publisher VARCHAR(255),
    ISBN VARCHAR(13),
    number_of_pages INT,
    available BOOLEAN DEFAULT TRUE
);

CREATE TABLE reader (
    reader_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    date_of_birth DATE,
    borrowed_books INT DEFAULT 0,
    penalty_count INT DEFAULT 0
);

CREATE TABLE borrowing (
    borrowing_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    reader_id INT,
    borrowing_date DATETIME,
    return_date DATETIME,
    overdue_penalty INT DEFAULT 0,
    FOREIGN KEY (book_id) REFERENCES book(book_id),
    FOREIGN KEY (reader_id) REFERENCES reader(reader_id)
);
```

<h3 id="library-db-population">3.5 Database DML data population with INSERT-VALUES statements:</h3>

```INSERT INTO library (library_name, library_address, library_phone_number, max_borrowings, borrowing_period_days, late_return_penalty_days)
VALUES 
    ('Biblioteca Islas Filipinas', 'Calle Jesús Maestro, 3', '915800811', 3, 15, 3);

INSERT INTO book (title, author, publication_year, publisher, ISBN, number_of_pages, available)
VALUES
    ('El Quijote', 'Miguel de Cervantes', 1605, 'Francisco de Robles', '9788424921862', 863, true),
    ('Moby Dick', 'Herman Melville', 1851, 'Harper & Brothers', '9781593080275', 635, false),
    ('Las aventuras de Huckleberry Finn', 'Mark Twain', 1884, 'Chatto & Windus', '9780486280615', 224, false),
    ('Fundación', 'Isaac Asimov', 1951, 'Gnome Press', '9780553293357', 244, false),
    ('El Señor de los Anillos', 'J.R.R. Tolkien', 1954, 'George Allen & Unwin', '9780618260584', 1178, true),
    ('El doctor Jekyll y Mr. Hyde', 'Robert L. Stevenson', 1886, 'Longmans, Green, and Co.', '9780141389509', 144, false),
    ('Robinson Crusoe', 'Daniel Defoe', 1719, 'W. Taylor', '9780060771504', 320, false),
    ('No es país para viejos', 'Cormac McCarthy', 2005, 'Vintage', '9780307387134', 320, true),
    ('El perro de los Baskerville', 'Arthur Conan Doyle', 1902, 'George Newnes Ltd', '9780143122065', 256, false),
    ('Vida y destino', 'Vasily Grossman', 1980, 'Ediciones Destino', '9788432209469', 896, true),
    ('La invención de Morel', 'Adolfo Bioy Casares', 1940, 'Editorial Losada', '9789500301429', 144, false),
    ('The stand', 'Stephen King', 1978, 'Doubleday', '9780385121682', 823, false),
    ('Rebelión en la granja', 'George Orwell', 1945, 'Secker and Warburg', '9780451526342', 112, true),
    ('Los miserables', 'Victor Hugo', 1862, 'A. Lacroix, Verboeckhoven & Cie', '9780192839983', 1232, true),
    ('Las metamorfosis', 'Ovidio', 8, 'Varios', '9780140447897', 723, false);
    
INSERT INTO reader (first_name, last_name, email, phone_number, date_of_birth, borrowed_books, penalty_count)
VALUES 
    ('George', 'Stobbart', 'george.stobbart@gmail.com', '626461866', '1979-06-18', 1, 0),
    ('Nicole', 'Collard', 'nico.collard@yahoo.com', '612445112', '1984-10-03', 2, 0),
    ('André', 'Lobineau', 'andre.lobineau@gmail.com', '691557349', '1985-12-29', 1, 0),
    ('Augustin', 'Rosso', 'augustin.rosso@yahoo.com', '680220093', '1971-04-05', 3, 0),
    ('Pierre', 'Carchon', 'pierre.carchon@bbc.co.uk', '616596154', '1999-01-12', 0, 0),
    ('Liam', 'McGuire', 'liam.mcguire@facebook.com', '677916387', '2002-07-30', 0, 0),
    ('Clarissa', 'Piermont', 'clarissa.piermont@altavista.com', '648915477', '1956-09-02', 0, 0),
    ('Duane', 'Henderson', 'duane.penderson@hotmail.com', '610468251', '1982-03-21', 0, 0),
    ('Pearl', 'Henderson', 'pearl.henderson@hotmail.com', '691465003', '1983-12-01', 1, 0),
    ('Bruno', 'Ostvalt', 'bruno.ostvalt@yahoo.com', '611025916', '1965-08-08', 0, 0),
    ('Nigel', 'Peagram', 'nigel.peagram@lycos.com', '696163171', '1991-02-17', 0, 0),
    ('François', 'Plantard', 'francois.plantard@google.com', '625526744', '1970-01-10', 1, 5),
    ('Jacques', 'Marquet', 'jacques.marquet@yahoo.com', '682412110', '1968-12-31', 0, 0),
    ('Antoine', 'Eklund', 'antoine.eklund@gmail.com', '646826952', '1975-06-10', 0, 0),
    ('Gamal', 'Khan', 'khan@google.com', '600168163', '1986-07-27', 0, 26);
    
INSERT INTO borrowing (book_id, reader_id, borrowing_date, return_date, overdue_penalty)
VALUES 
    (2, 2, '2022-09-02 11:43:03', '2022-09-13 10:16:19', 0),
    (13, 2, '2022-09-02 11:43:36', '2022-09-13 18:30:26', 0),
    (4, 1, '2022-09-13 18:31:18', '2022-09-21 13:01:06', 0),
    (8, 6, '2022-09-27 12:20:25', '2022-10-11 15:50:31', 0),
    (9, 8, '2022-10-02 17:00:42', '2022-10-18 11:09:12', 3),
    (3, 2, '2022-10-07 09:37:26', '2022-10-20 11:00:43', 0),
    (12, 2, '2022-10-07 09:37:40', '2022-10-20 11:00:59', 0),
    (1, 4, '2022-10-30 16:11:56', '2022-11-21 12:40:41', 21),
    (15, 7, '2022-12-02 15:50:42', '2022-12-19 15:15:16', 6),
    (5, 3, '2022-12-11 18:47:01', '2022-12-30 12:01:24', 12),
    (10, 2, '2022-12-11 10:13:43', '2022-12-25 13:30:20', 0),
    (11, 2, '2022-12-11 10:14:04', '2022-12-25 13:30:33', 0),
    (13, 8, '2022-12-13 14:04:30', '2022-12-28 11:00:33', 0),

    # Insertions relative to present day for penalties and current borrowings to make sense:
    (6, 15, DATE_SUB(NOW(), INTERVAL 33 DAY), DATE_SUB(NOW(), INTERVAL 7 DAY), 
        (((33 - 7) - (SELECT borrowing_period_days FROM library)) * (SELECT late_return_penalty_days FROM library))),
    (7, 2, DATE_SUB(NOW(), INTERVAL 19 DAY), NULL, 
        ((19 - (SELECT borrowing_period_days FROM library)) * (SELECT late_return_penalty_days FROM library))),
    (12, 2, DATE_SUB(NOW(), INTERVAL 17 DAY), NULL, 
        ((17 - (SELECT borrowing_period_days FROM library)) * (SELECT late_return_penalty_days FROM library))),
    (15, 3, DATE_SUB(NOW(), INTERVAL 16 DAY), NULL, 
        ((16 - (SELECT borrowing_period_days FROM library)) * (SELECT late_return_penalty_days FROM library))),
    (5, 12, DATE_SUB(NOW(), INTERVAL 18 DAY), CONCAT(CURDATE() - INTERVAL 1 DAY, ' 16:07:07'),
        (((18 - 1) - (SELECT borrowing_period_days FROM library)) * (SELECT late_return_penalty_days FROM library))),
    (6, 4, DATE_SUB(NOW(), INTERVAL 10 DAY), NULL, 0),
    (4, 4, DATE_SUB(NOW(), INTERVAL 13 DAY), NULL, 0),
    (11, 4, DATE_SUB(NOW(), INTERVAL 13 DAY), NULL, 0),
    (9, 12, DATE_SUB(NOW(), INTERVAL 7 DAY), NULL, 0),
    (2, 9, DATE_SUB(NOW(), INTERVAL 4 DAY), NULL, 0),
    (3, 1, CONCAT(CURRENT_DATE(), ' 08:34:05'), NULL, 0);
```

<h3 id="library-output">3.6 Console-Output:</h3>

```+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 1
Enter reader ID: 1
Book El Quijote borrowed successfully by George Stobbart and set 'unavailable'.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 3
Enter reader ID: 1
Book 'Las aventuras de Huckleberry Finn' returned successfully and set 'available'.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 1
Enter reader ID: 6
The book 'El Quijote' is already borrowed.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 10
Enter reader ID: 4
Reader Augustin Rosso has already the maximum borrowings.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 14
Enter reader ID: 15
Reader Gamal Khan has a late return or penalty and can't borrow books.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 11
Enter reader ID: 9
No borrowing found for the specified book and reader IDs.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 9
Enter reader ID: 12
Book 'El perro de los Baskerville' returned successfully and set 'available'.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 9
Enter reader ID: 2
Reader Nicole Collard has a late return or penalty and can't borrow books.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 15
Enter reader ID: 3
Book 'Las metamorfosis' returned successfully and set 'available'.
Late return penalty applied: 3 days.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 7
Enter reader ID: 2
Book 'Robinson Crusoe' returned successfully and set 'available'.
Late return penalty applied: 12 days.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 12
Enter reader ID: 2
Book 'The stand' returned successfully and set 'available'.
Late return penalty applied: 6 days.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
exit
Exiting program...
```

<br>

<h2 id="grade-curriculum">
  4. Grade Course Curriculum:
</h2>

- [Higher Technician in Multi-platform Applications Development (English)][1]
- [Técnico Superior en Desarrollo de Aplicaciones Multiplataforma (Español)][2]

[1]: https://www.todofp.es/dam/jcr:7655e32d-08a3-47a7-a479-ddb6f032c63e/n-tsdesarrolloaplicacionesmultiplataformaen-pdf.pdf
[2]: https://www.todofp.es/dam/jcr:c03b0ca3-58e3-4b1d-ac13-b2c006a9d5f2/n-tsdesarrolloaplicacionesmultiplataformaes-pdf.pdf

<br>

<h2 id="license">
  5. License:
</h2>

    Copyright (C) 2023  Alejandro M. González
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
    
    MIT License: http://opensource.org/licenses/MIT
