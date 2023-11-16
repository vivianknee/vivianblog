---
title: Unit 2 Lesson
categories: ['Lesson']
tags: ['java', 'lesson', 'classes']
type: hacks
week: 7
author: Vivian
description: Lesson on Unit 2
toc: True
date: 2023-10-04 12:00:00 +0000
---

## Unit 2.1- Objects: Instances of Classes

#### What are objects?

An **Object** is created from a class by calling the class constructor. 

#### What are classes?

A **Class** is a template that defines an object is like and what it can do. 

#### Objects are Instances of Classes

For example, if the class is a blueprint for a house, the object is a particular house. 



#### Example

Here is an example of creating a Student class in Java. It contains instance variables that define the characteristics of a student.


```java
public class Student {

    // instance variables or attributes
    String name;
    String teacher;
    int period;
  
    // constructor. allows you to directly pass in parameters when creating new objects 
    public Student(String name, String teacher, int period) {
      this.name = name;
      this.teacher = teacher;
      this.period = period;
    }
  }
```

Now, using our class, we can create student objects by initializing two students


```java
Student grace = new Student("Grace", "Mr. Mort", 3);
Student alice = new Student("Alice", "Mr. Mort", 1);
```

We can printout information about each student


```java
System.out.println(grace.name);
```

    Grace



```java
System.out.println(alice.period);
```

    1


#### Learning Objectives

- Explain the relationship between a class and an object.

#### Essential Knowledge

- An object is a specific instance of a class with defined attributes.
- A class is the formal implementation, or blueprint, of the attributes and behaviors of an object. 

## Unit 2.2- Creating and Storing Objects (Instantiation)

So, after we learned about **classes**, how are **objects** actually made?

Using our previous code, we can see created our constructor using 
```
public Student(String name, String teacher, int period) {
      this.name = name;
      this.teacher = teacher;
      this.period = period;
    }
```


```java
public class Student {

    // instance variables
    String name;
    String teacher;
    int period;
  
    // constructor
    public Student(String name, String teacher, int period) {
      this.name = name;
      this.teacher = teacher;
      this.period = period;
    }
  }
```

The **Student** is the name of the class. The first letter is capitalized according to Java naming conventions (camel-case naming conventions). Then, using the **new** keyword, we call the constructor to make a new **Student**. Inside the parentheses, we have the parameter list, where the values and characteristics of the object are entered.

```
Student grace = new Student("Grace", "Mr. Mort", 3);
```

The **parameters** in this case are "Grace", "Mr. Mort", and 3. 

#### Constructor Overloads

A class can have multiple constructors, however, the number of parameters must be different or the order must be different. This is an example of **overloading** the constructor.


```
// Constructor 1
Student(String name, String teacher, int period)


// Constructor 2
Student(String teacher, String name, int period)
```

This two constructors are not allowed. For example, if we call

```
Student("Grace", "Mr. Mort", 3);
```

we would not know whether Grace or Mr. Mort is the student.

However, constructors with different data types or different number of parameters are allowed when overloading. Here are some examples...

```
Student(String name, String teacher, int period)
Student(String name, String teacher)
Student()
```

#### Null Objects


```java
Student rachit = null;
```

Null basically states that no object exists, and it is not stored in memory. You cannot call methods on an object that is declared as null since null objects do not have any information or characteristics set to that object. This will create a NullPointerException

## Unit 2.3- Calling a Void Method

**method**: code that is called in order to achieve a task
- can be void or non-void, static or non-static

**void method**: do not return a value but instead change other things. These include changing characteristics of an object or printing text to the console. Here is an example...

```
public void methodName(parameterList)
```

**static method**: general to the class and not tied to any particular object. The method is denoted by the Here is an example ...

```
public static void add() {
  count++;
}

```

To call a static method, we use dot notation, with the class name coming before the method separated by a dot as follows

```
ClassName.add();
```

**non-static method**: acts on a particular object. For example, printing a person's name is a non-static method, since each person has a different name. For example...

```
public void printName() {
  System.out.println(name);
}
```

When calling a non-static method, we also use dot notation. But, instead of using the class name, we use the object name so we know what object the method acts on. Also, we don't need to do dot notation of ClassName.objectName.methodName() because an object already acts on a certain class, so using the class name is just redundant.  We would use printName() as follows...

```
objectName.printName();
```

Run the main method and see what the each of the methods prints out


```java
public class MyClass {

    // Static method
    public static void staticMethod() {
        System.out.println("This is a static method.");
    }

    // Non-static (instance) method
    public void nonStaticMethod() {
        System.out.println("This is a non-static method.");
    }

    // Method with void return type
    public void methodWithVoidReturnType() {
        System.out.println("This method has a void return type.");
    }

    public static void main(String[] args) {
        // Calling the static method
        staticMethod();

        // Creating an object of MyClass
        MyClass myObject = new MyClass();

        // Calling the non-static method on the object
        myObject.nonStaticMethod();

        // Calling the method with void return type
        myObject.methodWithVoidReturnType();
    }
}

```

- static methods can be called within a static context
- non static methods require creating an object to access the methods

### 2.6 String Objects: Concatenation, Literals, and More

Guess what's crazy? String literals are not actually primitives, they are considered objects! String literals are part of the aptly named String class included in Java and have a set of methods that come along with it. We'll see what we can do with the String class in the next topic!

There are two ways to make strings: using a pre-initialized string or by using a constructor. 


```java
String preInt = "Hello World!"; // How we usually initialize strings
System.out.println(preInt);

// Using a constructor:
String newString = new String("Hello World!");
System.out.println(newString);
```

    Hello World!
    Hello World!


#### Escape Characters
Sometimes, you want to put a quote in a string. However, you quickly find out that the opening quotation in the quote marks the "end" of the string and you can't type out your quote unless you want the program to crash. What can you do?

Challenge: Display the background of the quote while displaying the quote in one line: "Give me liberty or give me death!" - Patrick Henry.


```java
System.out.println("Give me liberty or give me death");
```

    Give me liberty or give me death


#### String Concatenation

When we combine two strings together, we call that string concatenation. We use the '+' operator to concatenate two strings. 


```java
System.out.println("I am" + "hungry");
```

    I amhungry


Notice how there is no space between am and hungry. This is because the java '+' operator does not add a space, but instead, joins the strings together without adding anything in between. To fix this, we add a space in between.


```java
System.out.println("I am" + " " + "hungry");
```

    I am hungry


However, when we want to use variables with our strings, we can also use the '+=' operator to concatenate our strings. The '+' operator still works, however.


```java
String a1 = "Hello ";
String a2 = "World";
System.out.println(a1 + a2);
System.out.println(a1 += a2);
```

    Hello World
    Hello World


Can you guess what happens when we try to change a string object?


```java
String s1 = "Hello"; // String literal
String s2 = "Hello"; // String literal
String s3 = s1; // same reference

//Changing the value of s1
s1 = "Java";

//Updating with concat() operation
s2.concat(" World");

//The concatenated String will be created as a new instance and an object should refer to that instance to get the concatenated value.
String newS3 = s3.concat(" Scaler");

System.out.println("s1 refers to " + s1);
System.out.println("s2 refers to " + s2);
System.out.println("s3 refers to " + s3);
System.out.println("newS3 refers to " + newS3);
```

    s1 refers to Java
    s2 refers to Hello
    s3 refers to Hello
    newS3 refers to Hello Scaler


The strings are immutable! This is because immutable strings allows Java to be safe in multithread applications (no changes that were not supposed to happen at that time in the program), and it makes the string object very efficient, as the strings are stored in a "string pool" that Java uses, which allows strings to only be created once but used over and over again if the same string object is created multiple times.

One last cool thing about strings is that primitive types change to string objects when concatenated. You have been doing this all the time, but here is the proof!


```java
String message = "Here is the key: ";
double key = 0.5;

System.out.println(message + key)
```

    Here is the key: 0.5


### 2.7 String Methods

#### Intro to External Libraries and APIs
There is a lot you can do with the factory version of Java, however, just like Python and many other languages, there are many new things you can do with the Java external libraries and APIs (application program interfaces). 
All Java classes, libraries, and APIs come with documentation, which lists the methods of the class and also how to use the class and its methods. Here is the official Java documentation for the String class:

[Java Docs](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)

Courtesy of Java.

#### About the String Class
__The String class is a class in the java.lang package that comes when you install Java on your computer.__
### Accessing Substrings
With strings, we can access substrings and characters in the string. A substring is a string that is included within a larger string, and a character is a substring with a length of 1. First, we need to figure out the length of a string, which is the number of characters in the string. To do this, we use the following method:


```java
String str = "Kaiden Do";
System.out.println(str.length())
```

    9


We can also get a index for the strings. For example, if we take "Kaiden Do"...

| Index | Character |
| --- | --- |
| 0 | K |
| 1 | a |
| 2 | i |
| 3 | d |
| 4 | e |
| 5 | n |
| 6 |   |
| 7 | D |
| 8 | o |


```java
String str = "Kaiden Do";
System.out.println(str.substring(0, 6)); // Range is [_,_)
System.out.println(str.substring(7, 9)); // Range is [_,_)
```

    Kaiden
    Do


How would we get the nth character of a string? Write a program to find it with an integer n that you can change to get the nth character in the cell below.


```java
String str = "Kaiden Do";
for (int i = 0; i < str.length(); i++){
    System.out.println(i);
}
```

    0
    1
    2
    3
    4
    5
    6
    7
    8


Question: If we have a string, what is its lower bound index and what is its upper bound index, if the string length is equal to the variable 'str'?

Question: What is the error for an out of bound string? Display it in the cell below.


```java

```

To do a ctrl-F search through a string, we can use the following process:


```java
String str = "He stared out the window at the snowy field. He'd been stuck in the house for close to a month and his only view of the outside world was through the window. There wasn't much to see. It was mostly just the field with an occasional bird or small animal who ventured into the field. As he continued to stare out the window, he wondered how much longer he'd be shackled to the steel bar inside the house.";
System.out.println(str.indexOf("animal"))
```

    246


To compare two strings to each other, we use two functions:


```java
// To check if a string is equal to another string:
String str1 = "I am hungry";
String str2 = "I am hungry";
System.out.println("Does string 1 equal string 2? True or false: " + str1.equals(str2));
String str2 = "I am not hungry";
System.out.println("Does string 1 equal string 2? True or false: " + str1.equals(str2));
```

    Does string 1 equal string 2? True or false: true
    Does string 1 equal string 2? True or false: false



```java
// To compare the lengths of the strings

// Case 1: String 1 is shorter than string 2
String str1 = "I am hungry";
String str2 = "I am not hungry";
System.out.println(str1.compareTo(str2)); // Returns less than 0

// Case 2: String 1 is equal string 2
String str1 = "I am hungry";
String str2 = "I am hungry";
System.out.println(str1.compareTo(str2)); // Returns 0

// Case 3: String 1 is longer than string 2
String str1 = "I am hungry";
String str2 = "Hello!";
System.out.println(str1.compareTo(str2)); // Returns greater than 0
```

    -6
    0
    1


compareTo() returns the difference of first unmatched character in the two compared strings. If no unmatch is found, and one string comes out as shorter than other one, then the length difference is returned. It also checks to see if a string comes before or after another string alphabetically.

### 2.8 Wrapper Classes: Integer and Double
You probably know what an integer is (if you don't see me after class immediatley!), and you probably know what a double is (again, if you don't see me after class immediatley!).


- Integers and Doubles are classes called <strong>wrapper classes</strong>!
- why?
    - These classes convert primitive data types (int/double) to a reference data type (object). We convert these because different data structures in java require different types of variables, some of which are only objects. By parsing the values of the primitive data to an object, we can send values to methods and structures that only take object values, like ArrayList, for example.

#### The integer Wrapper Class
The Integer class in Java is a wrapper class for the primitive data type int. It provides several methods that can be used to perform operations on int values. The constructor looks like this:


```java
Integer(int value)
```


    |   Integer(int value)

    '.class' expected

    


An example of this running is:


```java
Integer hungerRating = new Integer(5); // Send to an Object
int hungerRatingNum = hungerRating.intValue(); // Turn back into a primitive
```

An example of it being utilized is:


```java
ArrayList<int> list = new ArrayList<int>();  // This will cause a compile-time error
```

The above code will not work because ArrayList requires on object type, while we are passing a primitive type.


```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(5);  // Autoboxing will automatically convert the int 5 to an Integer object
System.out.println(list)
```

This code works because the 5 is being converted by the list.add, since the list uses integer objects. 

Challenge: In the cell below, demonstrate a function failing with an int and a function succeding with an integer. This cannot be an ArrayList. You are NOT allowed to use ChatGPT, Google AI, Llama 2, Bing AI, etc, however, you can Google for answers.


```java

```

Moreover, we can also get other data from the integer class, which is related to how Java functions.


```java
System.out.println("Integer Min Value: " + Integer.MIN_VALUE);
System.out.println("Integer Max Value: " + Integer.MAX_VALUE);
```

    Integer Min Value: -2147483648
    Integer Max Value: 2147483647


These numbers are the bounds of integers in java. For example, we can try going outside the range to see what happens.


```java
Integer pleaseBreak = new Integer(2147483648)
```


    |   Integer pleaseBreak = new Integer(2147483648);

    integer number too large

    


Challenge: Can we have a primitive int that goes past that bound? Try and find out in the cell below.


```java

```

#### Double Wrapper Classes

Double wrapper classes are basically the same thing as integer classes, however, they deal with double varaiables instead of integer variables. You write it like this:


```java
Double(Double Value)
```

Here is an example of using Double object:


```java
// My actual height in real life (in feet)
Double height = new Double(6.6); // Send to an Object
double primitiveHeight = height.doubleValue(); // Turn back into a primitive
```

And here is an example of when it works and when it does not.


```java
ArrayList<double> list = new ArrayList<double>();  // This will cause a compile-time error
```


    |   ArrayList<double> list = new ArrayList<double>();  // This will cause a compile-time error

    unexpected type

      required: reference

      found:    double

    

    |   ArrayList<double> list = new ArrayList<double>();  // This will cause a compile-time error

    unexpected type

      required: reference

      found:    double

    


Again, the ArrayList needs an object type, but we are passing a primitive type.


```java
ArrayList<Double> list = new ArrayList<Double>();
list.add(3.14);  // Autoboxing will automatically convert the double 3.14 to a Double object
```

This code works because the 3.14 is being converted by the list.add, since the list uses double objects. 

#### Autoboxing
Autoboxing is when Java automatically changes a basic data type into its object form. The Java compiler does this for us. Think of it as putting the data into a box. Java can also unbox an object, which is the exact opposite of autoboxing. When an Integer object is assigned to a primitive int type, Java will automatically use the primitive int version of the number and assign it to the int variable.


```java
// Boxing
int a = 5;
Integer b = a;
```


```java
// Unboxing
Integer x = new Integer(10);
int y = x;
```

### 2.9 Using the Math Class

Java has a built in math class called Math. It is a part of the java.lang class.

In the cell below, experiment and try to figure out a way to call Math.random and implement bounds, with your bounds being integer bounds of a and b.


```java

```

# Hacks
Hack 1: (0.25) Create a void method that takes an integer input and adds it to an ArrayList. Then, add a non-void method that is able to call a certain index from the ArrayList.


```java
import java.util.ArrayList;
import java.util.Scanner;

public class MyArrayList {
    private ArrayList<Integer> intList = new ArrayList<>();  
    private Scanner scanner = new Scanner(System.in); 

    public void addToIntArray() {
        int myInt = scanner.nextInt(); 
        intList.add(myInt);
    }

    public int callInteger() {
        System.out.println("Enter an index to retrieve an integer from the list:");
        int index = scanner.nextInt();
        System.out.println("the selected index was " + index);

        if (index >= 0 && index < intList.size()) {
            return intList.get(index);
        }

        return -1;
    }

    public static void main(String[] args){
        MyArrayList myList = new MyArrayList();
        System.out.println("Enter an integer to add to the list:");
        myList.addToIntArray();

        int retrievedValue = myList.callInteger();

        if (retrievedValue != -1) {
            System.out.println("Value at the requested index: " + retrievedValue);
        } else {
            System.out.println("Index is out of bounds.");
        }
    }
}

MyArrayList.main(null);

```

    Enter an integer to add to the list:
    Enter an index to retrieve an integer from the list:
    the selected index was 0
    Value at the requested index: 5


Hack 2: (0.25) Create a simple guessing game with random numbers in math, except the random number is taken to a random exponent (also includes roots), and the person has to find out what the root and exponent is (with hints!). Use at least one static and one non-static method in your class.


```java
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
   private double randomNumber;
   private double randomExponent;
   private double result;

   public double createRandomNumber(){
        double min = 0;
        double max = 10;

        randomNumber = Math.floor(Math.random() *(max - min + 1) + min);
        randomExponent = Math.floor(Math.random() *(max - min + 1) + min);
        result = Math.pow(randomNumber, randomExponent); 
        
        //print statements i was using to make sure this thing worked
        //System.out.println(randomNumber);
        //System.out.println(randomExponent);
        //System.out.println(randomNumber + " to the power of " + randomExponent);
        //System.out.println(result);
      
        return randomExponent;
    }

    public void guessingGame() {

        System.out.println("Welcome to the exponent/root guessing game");
        System.out.println("You need to guess the exponent/root, but don't worry there are hints!");

        Scanner guess = new Scanner(System.in);
        boolean correct = false;


        while(!correct) {
            System.out.print("Enter your guess: ");
            double myGuess = guess.nextDouble();

            if (myGuess == randomExponent) {
                System.out.println("That is correct, good job!");
                correct = true;
            }

            else if (myGuess > randomExponent){
                System.out.println("Your guess is too high. Would you like a hint? (say yes or no)");
                Scanner hint = new Scanner(System.in);
                String myHint = hint.next();
                if (myHint.equalsIgnoreCase("yes")){
                    System.out.println(randomNumber + " to the power of this random exponent is " + result);
                }
            }
            else {
                System.out.println("Your guess is too low. Would you like a hint? (say yes or no)");
                Scanner hint = new Scanner(System.in);
                String myHint = hint.next();
    
                if (myHint.equalsIgnoreCase("yes")){
                    System.out.println(randomNumber + " to the power of this random exponent is " + result);
                }
            }
        }
        
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.createRandomNumber();
        game.guessingGame();
       
    }
}

GuessingGame.main(null);
```

    Welcome to the exponent/root guessing game
    You need to guess the exponent/root, but don't worry there are hints!
    Enter your guess: Your guess is too low. Would you like a hint? (say yes or no)
    2.0 to the power of this random exponent is 512.0
    Enter your guess: Your guess is too low. Would you like a hint? (say yes or no)
    Enter your guess: Your guess is too low. Would you like a hint? (say yes or no)
    Enter your guess: That is correct, good job!



```java
public class test {
    
    public static void main(String[] args) {
        double min = 0;
        double max = 10;

        double randomNumber = Math.floor(Math.random() *(max - min + 1) + min);
        System.out.println(randomNumber);

        double randomExponent = Math.floor(Math.random() *(max - min + 1) + min);
        System.out.println(randomExponent);

        double result = Math.pow(randomNumber, randomExponent); 
        System.out.println(randomNumber + " to the power of " + randomExponent);

        System.out.println(result);
}

}

test.main(null);

```

    3.0
    6.0
    3.0 to the power of 6.0
    729.0


Hack 3: (0.25) Create a class of your choosing that has multiple parameters of different types (int, boolean, String, double) and put 5 data values in that list. Show that you can access the information by giving some samples.


```java
public class Car {

    private int year;
    private double price;
    private String brand;

    public Car(int year, double price, String brand) {
        this.year = year;
        this.price = price;
        this.brand = brand;
    }

    public static void main(String[] args) {
        Car car1 = new Car(1969, 50000, "Mustang");
        Car car2 = new Car(2000, 85000, "Tesla");
        Car car3 = new Car(1935, 65000, "Ford");
        Car car4 = new Car(2011, 100000, "Dodge");
        Car car5 = new Car(1988, 20000, "Honda");

        System.out.println(car1.year); 
        System.out.println(car2.brand); 
        System.out.println(car5.price); 
    }
}

Car.main(null);

```

    1969
    Tesla
    20000.0


Hack 4: (0.25) Using your preliminary knowledge of loops, use a for loop to iterate through a person’s first and last name, separated by a space, and create methods to call a person’s first name and a person’s last name by iterating through the string.


```java
import java.util.Scanner;

public class Name {

    public String getFullName() {
        Scanner fullNameScanner = new Scanner(System.in);
        String name = fullNameScanner.nextLine();
        return name;
    }

    public void firstName(String name) {
        System.out.println("Your first name is: ");
        int i = 0;
        while (i < name.length() && name.charAt(i) != ' ') {  
            System.out.print(name.charAt(i));
            i++;
        }
        System.out.println();
    }

    public void lastName(String name) {
        System.out.println("Your last name is: ");

        //stores the index of the ' ' in nameSeparator
        int nameSeparator = name.lastIndexOf(' ');

        if (nameSeparator != -1) {
            // nameSeparator + 1 because I want it to print everything after the space
            for (int i = nameSeparator + 1; i < name.length(); i++){
                System.out.print(name.charAt(i));
            }
        }
        System.out.println();
        
    }

    public static void main(String[] args) {
        Name newName = new Name();
        System.out.println("Enter your full name");
        String fullName = newName.getFullName();
        newName.firstName(fullName);
        newName.lastName(fullName);
    }
}

Name.main(null);
```

    Enter your full name
    Your first name is: 
    Vivian
    Your last name is: 
    Ni

