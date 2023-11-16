---
title: Unit 7 Lesson
categories: ['Lesson']
tags: ['java', 'lesson', 'arraylist']
type: hacks
week: 10
author: Vivian
description: Lesson on Unit 7
toc: True
date: 2023-10-24 12:00:00 +0000
---

# Unit 7: ArrayList
> Mastering the concept of Java's ArrayList. AP Exam weighting: 2.5-7.5%.

# 7.1: ArrayList Intro

- ArrayLists are dynamic, meaning their size can grow or shrink as needed, but arrays are static in size
- Instead of creating a new array of a different size and copying the data from the initial array to the new one, we can use ArrayLists

|Arrays|ArrayLists|
|-------|---------|
|Fixed Length|Resizable Length|
|Fundamental Java feature|Part of a framework|
|An object with no methods|Class with many methods|
|Not as flexible|Designed to be very flexible|
|Can store primitive data|Not designed to store primitives|
||Slightly slower than arrays|
||Need an import statement|

In order to use the ArrayList class, the ArrayList class needs to be imported from the java util package. This can be done by writing import java.util.ArrayList at the top of the class file.


```java
import java.util.ArrayList;  // Import the ArrayList class

// Declare and initialize an ArrayList of integers
ArrayList<Integer> numbersList = new ArrayList<>();
```

ArrayList objects are created in the same fashion as other object classes. The primary difference with ArrayLists is that the element type of the ArrayList must be specified using angled bracket <>. In this example, E represents the data type that will be used in the ArrayList. This can be replaced by an object data type:


```java
ArrayList<E> list = new ArrayList<E>();
```

We can actually declare ArrayLists without specifying the type that will be included in the ArrayList, but specifying the data type is smarter because it allows the compiler to find errors before run time, so its more efficient and easy to spot errors.


```java
ArrayList list = new ArrayList();
```

#### Quick lil popcorn hack

Create 2 ArrayLists, 1 called `studentName` and 1 called `studentAge`


```java
public class Student
{
    public static void main(String[] args)
    {
        //Initialize your ArrayLists
        ArrayList<String> studentName = new ArrayList<>();
        ArrayList<Integer> studentAge = new ArrayList<>();
        
    }
}
```

# 7.2: ArrayList Methods

### Learning Objectives

Students will be able to represent collections of related object reference data using `ArrayList` objects.

### Essential Knowledge

- Iteration statements provide a means to access all the elements stored within an `ArrayList`. This process is referred to as "traversing the `ArrayList`."

- The following `ArrayList` methods, including what they do and when they are used, are part of the Java Quick Reference:

    * `int size()` - Returns the count of elements within the list.
    * `boolean add(E obj)` - Appends the object `obj` to the end of the list and returns `true`.
    * `void add(int index, E obj)` - Inserts `obj` at the specified `index`, shifting elements at and above that position to the right (incrementing their indices by 1) and increasing the list's size by 1.
    * `E get(int index)` - Retrieves the element at the given `index` in the list.
    * `E set(int index, E obj)` - Replaces the element at the specified `index` with `obj` and returns the previous element at that index.
    * `E remove(int index)` - Deletes the element at the specified `index`, shifting all subsequent elements one index to the left, reducing the list's size by one, and returning the removed element.

- Java allows the generic `ArrayList<E>`, where the generic type `E` specifies the type of element.

- When `ArrayList<E>` is specified, the types of the reference parameters and return type when using the methods are type `E`.

- `ArrayList<E>` is preferred over `ArrayList` because it allows the compiler to find errors that would otherwise be found at runtime.

### Size of the `ArrayList`

* `int size();` : Returns the number of elements in the list.

Consider the following code:


```java
ArrayList<Integer> a1 = new ArrayList<>();
System.out.println(a1.size());
```

    0


### Adding Items to an `ArrayList`

* `boolean add(E obj);` : Appends `obj` to the end of the list and returns true.
* `void add(int index, E obj)` : Inserts `obj` at position `index`, as long as `index` is within the list's length. It moves each element in the list 1 index higher and adds 1 to the list's size.

Consider the following code:


```java
ArrayList<Double> a2 = new ArrayList<>();
a2.add(1.0);
a2.add(2.0);
a2.add(3.0);
a2.add(1, 4.0);
System.out.println(a2);
```

    [1.0, 4.0, 2.0, 3.0]


### Let's Look at an Example

Consider the following code:


```java
ArrayList<String> h = new ArrayList<>();

h.add("Hello");
h.add("Hello");
h.add("HeLLO");
h.add("Hello");
h.add(1, "Hola");

h.add(26.2);
h.add(new String("Hello"));
h.add(false);
```

Now, consider this code:


```java
ArrayList<String> g = new ArrayList<>();

g.add("Hello");
g.add("Hello");
g.add("HeLLO");
g.add("Hello");
g.add(1, "Hola");

g.add(new String("Hello"));

System.out.println(g);
```

    [Hello, Hola, Hello, HeLLO, Hello, Hello]


**Question:** Why does this code work? You cannot add a double to an arraylist with a String datatype

### Deleting Items from an `ArrayList`

`E remove(int index)` : Removes the element at position `index`, and moves the elements at position `index + 1` and higher to the left. It also subtracts one from the list's size. The return value is the element formerly at position `index`.


```java
// If you are confused of what list g is, look back at the previous code.
g.remove(3);
String former = g.remove(0);
System.out.println(former);
```

    Hello


### Updating Items in an `ArrayList`

`E set(int index, E obj)` : Replaces the element at position `index` with `obj` and returns the element formerly at position `index`.


```java
String helloFormer = g.set(1, "Bonjour");
System.out.println(helloFormer);
System.out.println(g);
```

    Hello
    [Hola, Bonjour, Hello, Hello]


### Accessing Items in an `ArrayList`

`E get(int index)` Returns the element at position `index` in the list.


```java
String hello = g.get(3);
System.out.println(hello);
System.out.println(g);
```

    Hello
    [Hola, Bonjour, Hello, Hello]


### Passing an `ArrayList` as a Method Parameter

The only time that it is wise to use `ArrayList` instead of `ArrayList<E>` is when it is as a function parameter and it is only using `ArrayList<>.get(E)` or `ArrayList<>.size()`. Consider the following code:


```java
private void accessOnly(ArrayList arr) {
    if (arr.size() > 0) {
        System.out.println(arr.get(0)); // Change the index to the one you want to access
    } else {
        System.out.println("Array is empty");
    }
}

ArrayList<Integer> myList = new ArrayList<Integer>();
accessOnly(myList);
```

    Array is empty


### Returning an `ArrayList` from a Method

In order for you to return an `ArrayList`, the data type must be specified, and the return type must be the same as the return value. Consider the following code:


```java
private ArrayList<String> returnTheSame() {
    ArrayList<String> arr = new ArrayList<String>(); // Initialize the ArrayList
    arr.add("Hello");
    return arr;
}

ArrayList<String> result = returnTheSame();
System.out.println(result);

```

    [Hello]


### Hacks

- The learning objective is that "Students will be able to represent collections of related object reference data using `ArrayList` objects." What does this mean to you?

- Answer the following questions:

    * Look back at *Size of the `ArrayList`*. What does the code output and why?
        - it prints the size of the array. since nothing has been added to it, the size is 0 and thus the output is 0
    
    * Look back at *Adding items to an `ArrayList`*. What does the code output and why? What type of function is `void`, and what will be the return value?
        - the code outputs the array with the values that have been added using the ".add" syntax
        - a void function is a function that does not return anything. in this case, void is used to indicate that the add method does not return a value

    * Look back at Example 1. What two lines did we remove? Why?
        - im not sure
    
    * If an `ArrayList` is being used as a parameter, what are the only two methods I can use from it? What would happen if I tried to use any other methods?
        - you can use read methods like get and size. you can also use iterate methods like for each loops

- Using the Hack Helper, write code that will:

    * Add 2 items to the list.
    * Remove an item from the list anywhere of the user's choice.
    * Replace am item anywhere in the list of the user's choice.
    * Get the first and last element of the list, no matter the length.
    * Return the items added, removed, replaced, and the list's size, in one string.

### Hack Helper


```java
import java.util.ArrayList;

public class ArrayListMethodsExample {

    private String manipulateList() {
        ArrayList<Integer> nums = new ArrayList<>();
        
        // add 2 items to the list
        nums.add(10);
        nums.add(20);
        
        // remove an item from the list (user's choice: index 1)
        if (nums.size() > 1) {
            nums.remove(1);
        }
        
        // replace an item in the list (user's choice: index 0)
        if (!nums.isEmpty()) {
            nums.set(0, 30);
        }
        
        // get the first and last element of the list (no matter the length)
        int firstElement = !nums.isEmpty() ? nums.get(0) : -1;
        int lastElement = !nums.isEmpty() ? nums.get(nums.size() - 1) : -1;
        
        // return the items added, removed, replaced, and the list's size in one string
        String result = "Items added: 10, 20\n";
        result += "Item removed: 20\n";
        result += "Item replaced: 30\n";
        result += "List size: " + nums.size();
        
        return result;
    }

    public static void main(String[] args) {
        ArrayListMethodsExample example = new ArrayListMethodsExample();
        String output = example.manipulateList();
        System.out.println(output);
    }
}

ArrayListMethodsExample.main(null);
```

    Items added: 10, 20
    Item removed: 20
    Item replaced: 30
    List size: 1


# 7.3: Traversing Arraylists

### Learning Objectives:
- With an Arraylist you can traverse objects using a for or while loop.

- Traversing objects is similar to iterating through objects.

### Essential Knowledge:
- Iteration statements can be used to accsess all the elements in an Arraylist. This is called traversing the Arraylist.

- Deleting elements during a traversal of an Arraylist requires special techniques to avoid skiping elements. This is called traversing the Arraylist.

- The indicies of an Arraylist start at 0; If you try to use any value lower than 0, you will get an *ArrayIndexOutOfBoundsException* error


```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> roster = new ArrayList<>();
        roster.add("Hello");
        roster.add("World");
        roster.add("Java");
        
        int sum = 0;
        for (int i = 0; i < roster.size(); i++) {
            String element = roster.get(i);
            if (element != null) {
                sum += element.length();
            }
        }
        System.out.println(sum);
    }
}


```

#### Breakdown:
- We are first declaring a new arraylist and adding a few elements.

- Next, we set the "sum" variable as 0.

- We set a for loop to traverse through the arraylist, iterating through all the indices in the arraylist and adding up the lengths of all the values.

- Lastly, we print it out.

#### Loop Conditions:

- There are a few diffrent loop conditions you can use to traverse an Arraylist:

>First, there are three major parts of a for loop:
>Initialisation, in which you declare the index, can be modified to change where you want to traverse from.

>Boolean condition, in which you declare the stop condition, can be modified in order to change the index you want to stop traversing in.

>Update, in which you declare how many indexes to go through, can be modified to skip certain indicies and traverse in a certain direction.

#### Practice:
Suppose we have an arraylist named grades, and we want to remove the entries that are lower than 70.
replace the question marks with code to solve the problem:


```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        grades.add(68.9);
        grades.add(71.0);
        grades.add(100.0);
        grades.add(80.0);
        for(int i = 0; i< grades.size(); i++){
            if(grades.get(i)<70){
                grades.remove(i);
            }
        }
        System.out.println(grades);
    }
}

Main.main(null);
```

    [71.0, 100.0, 80.0]


#### Using Enhanced For-Loop With Traversing:

- Using Enhanced for loop is easier to read and write and is also more concise and avoids errors.

- Indexes are not explicitly used and copies of the current element are made at each iteration.


```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> roster = new ArrayList<>();
        roster.add("Hello");
        roster.add("World");
        roster.add("Java");

        // Using an enhanced for loop to iterate through the ArrayList
        for (String element : roster) {
            System.out.println(element);
        }
    }
}
```

#### Common mistakes:
- Using the Wrong Data Type: Ensure that you declare your ArrayList with the correct data type. Using the wrong data type can lead to type mismatches and errors.

- Incorrect Indexing: Be cautious when using a standard for loop. Off-by-one errors or accessing elements that don't exist can lead to runtime exceptions.

- Modifying the List During Iteration: Modifying an ArrayList (adding or removing elements) while iterating over it can lead to a ConcurrentModificationException. To avoid this, use an Iterator or create a copy of the list if modifications are needed.

- Not Checking for Null Elements: When using enhanced for loops or iterators, check for null elements if there's a possibility that your list contains them to avoid NullPointerExceptions.

- Inefficient Searching: If you need to find a specific element, avoid using a linear search within a loop. Use appropriate methods like contains() or indexOf() to find elements efficiently.

## Hacks:
- Create a scenario which requires the use of arraylist traversal and create code to solve it. 
- Extra points to creative scenarios
- 90% credit to any working code and scenario
- 80% credit to incomplete code if you provide explanation of it
- -10% deduction for late submition

my scenario is about a treasure hunt game where a group of adventurers is exploring a maze. They have found various items along the way and need to figure out what they've collected to continue their adventure.


```java
import java.util.ArrayList;

public class TreasureHuntGame {

    public static void main(String[] args) { 
        ArrayList<String> itemsFound = new ArrayList<>();

        // adventurers finding items and adding them to the list.
        itemsFound.add("Golden Key");
        itemsFound.add("Torch");
        itemsFound.add("Map");
        itemsFound.add("Potion");
        itemsFound.add("Treasure Map");
        itemsFound.add("Compass");
 
        System.out.println("Items Found:");
        for (String item : itemsFound) {
            System.out.println("- " + item);
        }

        // check if the adventurers have found the essential items to continue.
        if (itemsFound.contains("Golden Key") && itemsFound.contains("Treasure Map")) {
            System.out.println("\nCongratulations! You have the Golden Key and the Treasure Map. You can continue your adventure to find the hidden treasure!");
        } else {
            System.out.println("\nYou need the Golden Key and the Treasure Map to continue your adventure. Keep searching!");
        }
    }
}

TreasureHuntGame.main(null);
```

    Items Found:
    - Golden Key
    - Torch
    - Map
    - Potion
    - Treasure Map
    - Compass
    
    Congratulations! You have the Golden Key and the Treasure Map. You can continue your adventure to find the hidden treasure!


# 7.4: Developing Algorithms Using ArrayLists

### Learning Objectives

In the context of `ArrayList` objects, this module aims to teach the following skills:

a. Iterating through `ArrayLists` using `for` or `while` loops.

b. Iterating through `ArrayLists` using enhanced `for` loops.

In the realm of algorithms, within the context of specific requirements that demand the utilization of `ArrayList` traversals, students will be able to:

- Recognize established algorithms.
- Customize existing algorithms.
- Create new algorithms.

### Essential Knowledge

- Iteration statements provide a means to access all the elements stored within an `ArrayList`. This process is referred to as "traversing the `ArrayList`."

- The following methods related to `ArrayLists`, their functions, and appropriate use are covered in the Java Quick Reference:

    * `int size()` - Returns the count of elements within the list.
    * `boolean add(E obj)` - Appends the object `obj` to the end of the list and returns `true`.
    * `void add(int index, E obj)` - Inserts `obj` at the specified `index`, shifting elements at and above that position to the right (incrementing their indices by 1) and increasing the list's size by 1.
    * `E get(int index)` - Retrieves the element at the given `index` in the list.
    * `E set(int index, E obj)` - Replaces the element at the specified `index` with `obj` and returns the previous element at that index.
    * `E remove(int index)` - Deletes the element at the specified `index`, shifting all subsequent elements one index to the left, reducing the list's size by one, and returning the removed element.

- There exist established algorithms for `ArrayLists` that make use of traversals to:

    * Insert elements.
    * Remove elements.
    * Apply the same algorithms commonly used with 1D arrays.

## Popcorn Hacks:

Before you uncomment the code and run it, guess what the code will do based on what you've learned.
- it will iterate through the length of values prints the max value in an array.

### Let's Look at an Example (Example 1)


```java
public class ArrayListExample {
    private double findMax(double[] values) {
        double max = values[0];
    
        for (int index = 1; index < values.length; index++) {
           if (values[index] > max) {
               max = values[index];
           }
        }
    
        return max;
    }
    
    public static void main(String[] args) {
        double[] nums = {1.0, 3.0, 2.0, 2.0, 1.0, 69.0, 2.0, 4.0, 6.0, 2.0, 5.0, 10.0};
        ArrayListExample example = new ArrayListExample();
        double max = example.findMax(nums);
        System.out.println("Maximum value: " + max);
    }
}

ArrayListExample.main(null);
```

    Maximum value: 69.0


Take a closer look at the `findMax()` method. It takes in a list of doubles as parameters. It will then use a `for` loop to find the maximum value in the list. Now, using what we know, can we replace the list of doubles with an ArrayList of Doubles? We sure can! Take a look at how we can use ArrayList to do just that:


```java
public class ArrayListExample {
    private double findMax(ArrayList<Double> values) {
        double max = values.get(0);
    
        for (int index = 1; index < values.size(); index++) {
           if (values.get(index) > max) {
               max = values.get(index);
           }
        }
    
        return max;
    }
    
    public static void main(String[] args) {
        ArrayList<Double> nums = new ArrayList<>();
        nums.add(1.0);
        nums.add(3.0);
        nums.add(2.0);
        nums.add(2.0);
        nums.add(1.0);
        nums.add(69.0);
        nums.add(2.0);
        nums.add(4.0);
        nums.add(6.0);
        nums.add(2.0);
        nums.add(5.0);
        nums.add(10.0);
        
        ArrayListExample example = new ArrayListExample();
        double max = example.findMax(nums);
        System.out.println("Maximum value: " + max);
    }
}

ArrayListExample.main(null);
```

    Maximum value: 69.0


### Let's Look at an Example (Example 2)

Take a look at this code:


```java
public class ArrayListExample {
    //finds the minimum
    private int findMin(int[] values) {
        int min = Integer.MAX_VALUE; 
        for (int currentValue : values) { //uses enhanced for loop
           if (currentValue < min) { //if current value is less than current min
               min = currentValue; //replace
           }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {420, 703, 2034, 582, 1047, 4545};
        ArrayListExample example = new ArrayListExample();
        int min = example.findMin(nums);
        System.out.println("Minimum value: " + min);
    }
}

ArrayListExample.main(null);
```

    Minimum value: 420


Now, can we use ArrayLists to make this code better? We sure can! Take a look at the new and improved code that uses ArrayLists:


```java
public class ArrayListExample {
    private int findMin(ArrayList<Integer> values) {
        int min = Integer.MAX_VALUE;
        for (int currentValue : values) {
           if (currentValue < min) {
               min = currentValue;
           }
        }
        return min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(420);
        nums.add(703);
        nums.add(2034);
        nums.add(582);
        nums.add(1047);
        nums.add(4545);
        ArrayListExample example = new ArrayListExample();
        int min = example.findMin(nums);
        System.out.println("Minimum value: " + min);
    }
}

ArrayListExample.main(null);
```

    Minimum value: 420


### Hacks

- Answer the questions: 
    * Look back at the examples. What's similar? What's different?
        - Both aim to find the minimum value within a list of integers. they both have a findMin Method that performs the task of finding the minimum value. they also both use a for-each loop to iterate through the elements
        - The first code snippet uses an array of integers (int[]). The second code snippet uses an ArrayList of integers (ArrayList<Integer>). In the first code , elements are accessed using array indexing, while in the second code, elements are accessed using the for-each loop with an ArrayList.

    * Why do we use `ArrayList`? Why not just regular lists?
        - ArrayLists offer dynamic sizing, making it easier to manage collections that you want to add or delete from. They provide more abstraction and are more flexible since they can store objects of any type.
        
- Demonstrate at least two `ArrayList` methods that aren't `ArrayList<>.size()` and `ArrayList<>.get()`.
    - two methods that aren't size and get are add and remove



```java
import java.util.ArrayList;

public class Colors {

    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();

        // adding elements to the ArrayList using the add method.
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        
        System.out.println("ArrayList after adding elements: " + colors);

        // removing the element at index 1 (which is "Blue").
        colors.remove(1);
        
        System.out.println("ArrayList after removing an element: " + colors);
    }
}

Colors.main(null);
```

    ArrayList after adding elements: [Red, Blue, Green]
    ArrayList after removing an element: [Red, Green]


- Write the method `findSum()` using the Hack Helper and incorporating `ArrayList`.

### Hack Helper


```java
import java.util.ArrayList;

public class ArrayListHacks {
    private int findSum(ArrayList<Integer> values) {
        int sum = 0;  
        for (int value : values) {
            sum += value; // accumulate the sum
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(8);

        ArrayListHacks hacks = new ArrayListHacks();
        int sum = hacks.findSum(nums);
        System.out.println("Sum of the numbers: " + sum);
    }
}

ArrayListHacks.main(null);
```

    Sum of the numbers: 19


# 7.5 Searching

### Learning Objectives
- Apply sequential/linear search algorithms to search for specific information in array or ``arraylist`` objects

### Essential Knowledge:
- Sequential/linear search alogorithms check each element in order untill the desired value is found or all elementsin the array or ``arraylist`` have been checked

### Search Process
- Linear searching fits a standard for loop perfectly! We need to specify each element, one at a time, and do not need to track the index after execution

- Inside the for loop, we retrieve the value from the structure at the specified index and compare it to the searched value

- If it matches we return the index, otherwise we keep looking!

### Searching Linear Structures

#### Finding information with a computer is something we need to know how to do. Linear search algorithms are BEST used when we do not have any idea about the order of the data and so we need to look at each element to determine if what we are looking for is in fact inside the array or ``ArrayList``.

#### When searching, we do need to remember that different data types require comparisons!
- When looking at ``int`` values, the == operator is the tool to use!
- When searching for a ``double`` value, we need to make sure the value is close enough by doing some math!
- ``Object`` instances should always use the ``.equals(otheThing)`` method to check for a match!

## Searching an ``ArrayList`` of Double


```java
public int where(double magicNumber, ArrayList<Double> realNumbers, double delta)
{
    for (int index = 0; index < realNumbers.size(); index++)
    {
        if (Math.abs(magicNumber - realNumbers.get(index)) < delta)
        {
            return index;
        }
    }
    return -1;
}
```

### Explanation
> The where function searches through a list of numbers to find and return the position of the first number that is very close to a specific target number, known as magicNumber. If no number in the list is close enough to the target number, the function returns -1, indicating that no match was found.

## Searching an ``ArrayList`` of book for a ``String``


```java
public int findTheWord(String searchedPhrase, ArrayList<Book> myBooks)
{
    for (int index = 0; index < myBooks.size(); index++)
    {
        Book currentBook = myBooks.get(index);
        String currentPhrase = currentBook.getDescription();
        if(currentPhrase.equals(searchedPhrase))
        {
            return index;
        }
    }
    return -1;
}
```

### Explanation
>This little code snippet is like a treasure hunt through a collection of books; it's on a mission to find the one book whose description matches exactly with a special phrase you're looking for. If it finds the perfect match, it'll excitedly tell you where it is in the collection, but if not, it'll sadly let you know with a -1 that the search was a bust.





## Questions

#### Should we use == when looking for an Object?
> No, that only will return true if the variable and the element stored at that index point to the same memory, are aliases of each other

#### Why did we subtract the double values?
> To make sure that the lack of preciosin that is inherit in the data type is handled within our code

## Why does order sometimes matter?

#### When searching for a value to remove from a list, if we search forward we have to make sure to adjust the loop control variable, or we might skip what we are looking for when removing!

# 7.6 Sorting

### Learning Objectives
- Apply selection sort and insertion sort algorithms to sort the elements of array or ``ArrayList`` objects.

### Essential Knowledge:
- Selection sort and insertion sort are iterative sorting algorithms that can be used to sort elements in an array or ``ArrayList``.



## Selection Sort
> This is one of the easiest sorts to demonstrate. The selection sort identifies either the maximum or minimum of the compared values and iterates over the structure checking if the item stored at the index matches that condition, if so, it will swap the value stored at that index and continue. This implementation uses a helper method to perform the swap operation since variables can hold only one value at a time!

Example:


```java
// with normal arrays
for (int outerLoop = 0; outerLoop < myDucks.length; outerLoop ++)
{
    int minIndex = outerLoop;
    for (int inner = outerLoop +1; inner < myDucks.length; inner++)
    {
        if (myDucks[inner].compareT(myDucks[minIndex]) < 0)
        {
            minIndex = inner;
        }
    }
    if (minIndex != outerLoop)
    {
        swapItems(minIndex, outerloop, myDucks);
    }
}

// with array lists
for (int outerLoop = 0; outerLoop < myDucks.size(); outerLoop++) {
    int minIndex = outerLoop;
    for (int inner = outerLoop + 1; inner < myDucks.size(); inner++) 
    {
        if (myDucks.get(inner).compareT(myDucks.get(minIndex)) < 0) 
        {
            minIndex = inner;
        }
    }
    if (minIndex != outerLoop) {
        swapItems(minIndex, outerLoop, myDucks); 
    }
}
/*
This code performs a selection sort on the myDucks ArrayList, ordering its elements based on the compareT method. 
During each iteration of the outer loop, it finds the index of the minimum element in the unsorted portion of the list and swaps it with the first element of the unsorted portion.
 */ 
```

## Insertion Sort Algorithm
> The insertion sort is characterized by building a sorted structure as it proceeds. It inserts each value it finds at the appropriate location in the data structure. This is often accomplished by using a while loop as the inner loop.

Example:


```java
for (int outer = 1; outer < randomList.size(); outer++)
{
    DebugDuck tested = randomList.get(outer);
    int inner = outer -1;

    while ( innter >= 0 && tested.compareTo(randomList.get(inner)) < 0)
    {
        ramdomList.set(inner +1, randomList.get(inner));
        inner--;
    }
    randomList.set(inner +1, tested)
}
// This code arranges a list of DebugDuck objects in order using the insertion sort method, 
// by moving through the list and putting each item in its proper place one by one.
```

# 7.7: Ethical Issues around Data Collection

### Learning Objectives:
- Explaining the risks of privacy from collecting and storing personal data on computer systems.

### Essential Knowledge:
- When using the computer, personal privacy is at risk. Programmers should attempt to safeguard personal privacy.

#### Privacy Protection:
- A simple way to protect privacy is to delete personal user info after done using it.
- Another way is to minimize the amount of data used by the program in order to protect privacy.
- Anonymizing personal data via the object method *hashCode()* is another way.

## Hacks:
- Think of other ways to safeguard user privacy (any other method not listed is fine)
- Extra points to creative solutions
- 90% credit to any solution
- 80% credit to incomplete solution (how did you do that?)
- -10% deduction for late submition

- Encrypt sensitive user data both at rest and in transit. 
- Use data masking techniques to replace sensitive information with masked or fake data
- Automatically delete user data that is no longer needed after a certain period. 
- Use AI and machine learning for user data protection by detecting and preventing privacy breaches in real-time.

# Grading:

- 7.2 Hacks (0.19)
- 7.3 Hacks (0.19)
- 7.4 Hacks (0.19)
- 7.7 Hacks (0.19)
- Popcorn Hacks (0.19)
- Anything else creative or above-and-beyond showing your understanding of ArrayLists (0.05)
