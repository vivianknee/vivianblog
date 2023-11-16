---
title: Unit 6 Lesson
categories: ['Lesson']
tags: ['java', 'lesson', 'arrays']
type: hacks
week: 9
author: Vivian
description: Lesson on Unit 6
toc: True
date: 2023-10-17 12:00:00 +0000
---

# 6.3 Enhanced for loop for Arrays
- the enhanced for loop is also known as the "for each" loop
- provides a simplified way to loop through elements in an array, collection, or other iterable data structures. 


```java
//syntax for enhanced for loop
for (dataType element : array) {
    // code to process 'element'
}
```

- the data type in the loop must match the array's element data type.


```java
//array of int matches element int
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}
```

    1
    2
    3
    4
    5


### Comparing a regular for loop with the enhanced for loop
**Rewrite this code to use an enhanced for loop instead. make comments explaining what you added/changed**


```java
import java.util.List;

class Quote {
    private List<String> quotes;
    private List<String> emotions;

    public Quote(List<String> quotes, List<String> emotions) {
        this.quotes = quotes;
        this.emotions = emotions;
    }

    public void printQuotesWithEmotions() {
        //changes made here. 
        for (int i = 0; i < quotes.size() && i < emotions.size(); i++) {
            String quote = quotes.get(i);
            String emotion = emotions.get(i);
            System.out.println("Quote: \"" + quote + "\"");
            System.out.println("Emotion: " + emotion);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        List<String> quotes = List.of(
            "Success is not final, failure is not fatal: It is the courage to continue that counts.",
            "The only way to do great work is to love what you do.",
            "The best way to predict the future is to create it."
        );

        List<String> emotions = List.of(
            "Courageous",
            "Passionate",
            "Innovative"
        );

        Quote quotePrinter = new Quote(quotes, emotions);
        quotePrinter.printQuotesWithEmotions();
    }
}

Quote.main(null);


```

    Quote: "Success is not final, failure is not fatal: It is the courage to continue that counts."
    Emotion: Courageous
    ---------------------------
    Quote: "The only way to do great work is to love what you do."
    Emotion: Passionate
    ---------------------------
    Quote: "The best way to predict the future is to create it."
    Emotion: Innovative
    ---------------------------


**What are some of the benefits of using an enhanced for loop in this case versus a regular for loop?**

### Limitations to enhanced for loop
- it does not provide access to the index of the current element. 
    - This means you cannot easily determine the position of the element in the array or collection. 
    - But when you want to search for a specific element in a collection and you don't necessarily need to access the index
    - If you need to work with indices, you should use a traditional for loop instead.
- read-only access to elements. 
    - You cannot modify the elements within the loop
    - Thus, when you need to modify a collection based on a condition. You should use a regular for loop

**For the next two code blocks, decide whether or not its better to use a regular for loop or an enhanced one, explain why. write the code for them**

1. Searching for an Element in an ArrayList 


```java
ArrayList<String> names = new ArrayList<>();
String searchName = "Vivian";

//code goes here
for () {
}
```

2. Removing Even Numbers from an ArrayList 


```java
ArrayList<Integer> numbers = new ArrayList<>();

//code goes here
for () {
   
}
```
