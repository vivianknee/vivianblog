---
toc: True
title: Blog on Sorting
type: hacks
week: 26
date: 2024-04-04 12:00:00 +0000
---

# Algorithmic Dance
[Issue](https://github.com/Codemaxxers/triangleblogs/issues/1#issue-2216150117)

# What is Comparable?
- `implements Comparable` is a Java interface that indicates that a class is comparable to other objects of the same type. 

- When a class implements the `Comparable` interface, it must provide an implementation for the `compareTo()` method, which compares the current object with another object of the same type. (can see down below in my code)

- The `compareTo()` method returns an integer value indicating whether the current object is less than, equal to, or greater than the specified object. 
    - returns a negative integer if the current object is less than the specified object,
    - returns a zero if they are equal
    - returns a positive integer if the current object is greater than the specified object.

- Implementing the `Comparable` interface allows instances of the class to be naturally ordered, which is useful for sorting collections of objects or for defining a natural ordering for elements in data structures like trees or priority queues. 

- For example, in my code , the `Book` class implements the `Comparable<Book>` interface, allowing `Book` objects to be compared based on their number of pages. 

# What is Collectable?
- collectable" usually refers to an object that can be gathered or accumulated 
- an object that can be stored and manipulated within data structures such as lists, sets, maps, etc.


## Data Differences with Sorting Methods
- large data sets
    - quick
    - merge
- small data sets
    - bubble
    - insertion
    - selection


```java
import java.util.ArrayList;
import java.util.Collections;

// Book class implements Comparable
public class Book implements Comparable<Book> {
    private String title;
    private int numberOfPages;

    public Book(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.numberOfPages, other.numberOfPages);
    }

    public static ArrayList<Book> createList() {
        Book b1 = new Book("Three Body Problem", 302);
        Book b2 = new Book("The Book Thief", 584);
        Book b3 = new Book("Angels and Demons", 768);
        Book b4 = new Book("The Da Vinci Code", 689);
        Book b5 = new Book("Silent Patient", 336);
        Book b6 = new Book("Good Girl's Guide to Murder", 400);
        Book b7 = new Book("Scythe", 336);
        Book b8 = new Book("Cruel Prince", 384);
        Book b9 = new Book("When Breathe Becomes Air", 228);
        Book b10 = new Book("Normal People", 288);

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
        bookList.add(b6);
        bookList.add(b7);
        bookList.add(b8);
        bookList.add(b9);
        bookList.add(b10);

        Collections.shuffle(bookList);

        return bookList;
    }
}

```


```java
public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public void reset() {
        startTime = 0;
        endTime = 0;
    }
}
```


```java
public class SortingMethods {

    public static void bubble(ArrayList<Book> bookList){
        int n = bookList.size();
        //iterates through each item in the list
        for (int i=0; i < n - 1; i++) {
            //ensures that the comparison is done only on the unsorted portion of the list
            for (int j=0; j < n - i - 1; j++){
                //uses the compare to method in the Book class
                if (bookList.get(j).compareTo(bookList.get(j + 1))> 0)
                    Collections.swap(bookList, j, j+1);
            }
        }
    }

    public static void insertion(ArrayList<Book> bookList){
        int n = bookList.size();
        //since i = 1 don't need to subtract from n
        //index starts at second item in the list to be sorted
        for (int i = 1; i < n; i++) {
            Book key = bookList.get(i);
            //j is the element before key that is being compared to
            int j = i - 1;

            //move elements greater than key one forward
            while (j >= 0 && bookList.get(j).compareTo(key) > 0) {
                //bigger element j moves up
                bookList.set(j + 1, bookList.get(j));
                j = j-1;
            }

            //re
            bookList.set(j + 1, key);
        }

    }

    public static void selection(ArrayList<Book> bookList){
        int n = bookList.size();

        for (int i = 1; i < n - 1; i++) {
            int min_index = i;
            //start at j = i+1 because thats what we are comparing the first element to
            for (int j = i+1; j < n; j++) {
                //find the minimum element in the arraylist
                if (bookList.get(j).compareTo(bookList.get(min_index)) < 0) {
                    min_index = j;
                }
            }

            // swap found min element with first element
            Collections.swap(bookList, min_index, i);
        }

    }

    public static void merge(List<Book> bookList) {
        if (bookList.size() > 1) {
            //split list in half
            int mid = bookList.size() / 2;

            //create list halves
            List<Book> left = new ArrayList<>(bookList.subList(0, mid));
            List<Book> right = new ArrayList<>(bookList.subList(mid, bookList.size()));

            //sort each side of the arraylist
            merge(left);
            merge(right);

            //k is to keep track of the index in the main merged list
            int i = 0, j = 0, k = 0;

            while (i < left.size() && j < right.size()) {
                //compares the element at the index of the left and right array, if left is greater it is added and right index increments by 1. vice versa
                if (left.get(i).compareTo(right.get(j)) <= 0) {
                    bookList.set(k, left.get(i++));
                    i++;
                } else {
                    bookList.set(k, right.get(j++));
                    j++;
                }
                k++;
            }

            //checks for leftover elements in each half of the arraylist
            while (i < left.size()) {
                bookList.set(k++, left.get(i++));
            }

            while (j < right.size()) {
                bookList.set(k++, right.get(j++));
            }

            }
     }

    public static void quick(ArrayList<Book> bookList) {
        quickSort(bookList, 0, bookList.size() - 1);
    }

    private static void quickSort(ArrayList<Book> bookList, int low, int high) {
        if (low < high) {
            //partition method is called to partition the list around a pivot element
            int pi = partition(bookList, low, high);

            //recursively sort both halves of the list
            quickSort(bookList, low, pi - 1);
            quickSort(bookList, pi + 1, high);
        }
    }

    //partition method for quick start.
    private static int partition(ArrayList<Book> bookList, int low, int high) {
        Book pivot = bookList.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            //compares the element starting from low to the pivot element
            if (bookList.get(j).compareTo(pivot) < 0) {
                i++;
                Collections.swap(bookList, i, j);
            }
        }

        //pivot element is placed correctly in the list
        Collections.swap(bookList, i + 1, high);
        return i + 1;
    }

    public static void main(String[] args) {
        ArrayList<Book> bookList = Book.createList();

        // Test Bubble Sort
        System.out.println("Bubble Sort:");
        Timer timer = new Timer();
        timer.start();
        bubble(bookList);
        timer.stop();
        System.out.println("Sorted List:");
        printBooks(bookList);
        System.out.println("Time taken: " + timer.getElapsedTime() + " ns");

        // Test Insertion Sort
        System.out.println("\nInsertion Sort:");
        timer.reset();
        timer.start();
        insertion(bookList);
        timer.stop();
        System.out.println("Time taken: " + timer.getElapsedTime() + " ns");

        // Test Selection Sort
        System.out.println("\nSelection Sort:");
        timer.reset();
        timer.start();
        selection(bookList);
        timer.stop();
        System.out.println("Time taken: " + timer.getElapsedTime() + " ns");

        // Test Merge Sort
        System.out.println("\nMerge Sort:");
        timer.reset();
        timer.start();
        merge(bookList);
        timer.stop();
        System.out.println("Time taken: " + timer.getElapsedTime() + " ns");

        // Test Quick Sort
        System.out.println("\nQuick Sort:");
        timer.reset();
        timer.start();
        quick(bookList);
        timer.stop();
        System.out.println("Time taken: " + timer.getElapsedTime() + " ns");
    }

    private static void printBooks(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book.getTitle() + " (" + book.getNumberOfPages() + " pages)");
        }
    }
}

SortingMethods.main(null);

```

    Bubble Sort:
    Sorted List:
    When Breathe Becomes Air (228 pages)
    Normal People (288 pages)
    Three Body Problem (302 pages)
    Silent Patient (336 pages)
    Scythe (336 pages)
    Cruel Prince (384 pages)
    Good Girl's Guide to Murder (400 pages)
    The Book Thief (584 pages)
    The Da Vinci Code (689 pages)
    Angels and Demons (768 pages)
    Time taken: 20250 ns
    
    Insertion Sort:
    Time taken: 4833 ns
    
    Selection Sort:
    Time taken: 6041 ns
    
    Merge Sort:
    Time taken: 27625 ns
    
    Quick Sort:
    Time taken: 9958 ns


same code, except this time, I use collectables


```java
import java.util.ArrayList;
import java.util.Collections;

// Collectable class implements Comparable
class Collectable implements Comparable<Collectable> {
    private String name;
    private int value;

    public Collectable(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Collectable other) {
        return Integer.compare(this.value, other.value);
    }
}

// Book class extends Collectable
class Book extends Collectable {
    private int numberOfPages;

    public Book(String name, int numberOfPages, int value) {
        super(name, value);
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}

public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public void reset() {
        startTime = 0;
        endTime = 0;
    }
}

public class SortingMethods {

    public static void bubble(ArrayList<Collectable> collectableList) {
        int n = collectableList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (collectableList.get(j) instanceof Book && collectableList.get(j + 1) instanceof Book) {
                    Book book1 = (Book) collectableList.get(j);
                    Book book2 = (Book) collectableList.get(j + 1);
                    if (book1.getNumberOfPages() > book2.getNumberOfPages()) {
                        Collections.swap(collectableList, j, j + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Collectable> collectableList = new ArrayList<>();
        collectableList.add(new Book("Three Body Problem", 302, 20));
        collectableList.add(new Book("The Book Thief", 584, 15));
        collectableList.add(new Book("Angels and Demons", 768, 10));
        collectableList.add(new Book("The Da Vinci Code", 689, 5));
        collectableList.add(new Book("Silent Patient", 336, 8));
        collectableList.add(new Book("Good Girl's Guide to Murder", 400, 25));
        collectableList.add(new Book("Scythe", 336, 30));
        collectableList.add(new Book("Cruel Prince", 384, 50));
        collectableList.add(new Book("When Breathe Becomes Air", 228, 100));
        collectableList.add(new Book("Normal People", 288, 70));

        Collections.shuffle(collectableList);

        //test Bubble Sort
        System.out.println("Bubble Sort:");
        Timer timer = new Timer();
        timer.start();
        bubble(collectableList);
        timer.stop();
        System.out.println("Sorted List:");
        printCollectables(collectableList);
        System.out.println("Time taken: " + timer.getElapsedTime() + " ns");
 

    }

    private static void printCollectables(ArrayList<Collectable> collectables) {
        for (Collectable collectable : collectables) {
            if (collectable instanceof Book) {
                Book book = (Book) collectable;
                System.out.println(book.getName() + " (" + book.getNumberOfPages() + " pages, Value: " + book.getValue() + ")");
            }
        }
    }
}

SortingMethods.main(null);
```

    Bubble Sort:
    Sorted List:
    When Breathe Becomes Air (228 pages, Value: 100)
    Normal People (288 pages, Value: 70)
    Three Body Problem (302 pages, Value: 20)
    Silent Patient (336 pages, Value: 8)
    Scythe (336 pages, Value: 30)
    Cruel Prince (384 pages, Value: 50)
    Good Girl's Guide to Murder (400 pages, Value: 25)
    The Book Thief (584 pages, Value: 15)
    The Da Vinci Code (689 pages, Value: 5)
    Angels and Demons (768 pages, Value: 10)
    Time taken: 11292 ns


## Notes
- Using a superclass like Collectable provides a more flexible and scalable approach compared to directly using the class name like Book
- By using a superclass, you can treat objects of different subclasses (like Book, Coin, Stamp, etc.) uniformly through polymorphism. This allows you to write more generic code that can work with various types of collectables without knowing their specific implementations.
- If you have common properties or behaviors among different types of collectables, you can define them in the superclass (Collectable) and inherit them in the subclasses (Book, Coin, etc.)

## Linked List Research
- a linked list is a linear data structure where each element is a separate object called a "node." Each node contains two parts: the data and a reference (or link) to the next node in the sequence

### Why are they better than arrays?
- Unlike arrays, linked lists do not have a predetermined size, and their elements are not stored in contiguous memory locations
- Insertion and deletion operations can be more efficient in linked lists compared to arrays, especially for large data sets. In a singly linked list, adding or removing an element at the beginning or end of the list typically requires only updating a few references, whereas in arrays, it may involve shifting multiple elements.

### Drawbacks
- slower access time for arbitrary elements (compared to arrays) and the additional memory overhead for storing references.


```java
//node class
//each node represents an element in the linked list.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data; //stores actual value
        this.next = null; //stores reference to next node
    }
}

//class to manage the linked list
class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // method to insert a new node at the end of the linked list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // method to access an arbitrary element by its position
    public int get(int position) {
        Node current = head;
        int index = 0;
        while (current != null && index < position) {
            current = current.next;
            index++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Position is out of bounds.");
        }
        return current.data;
    }
}

public class Main {
    public static void main(String[] args) {
        // create a new linked list
        LinkedList list = new LinkedList();

        // insert some elements into the list
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        // display the elements of the list
        System.out.println("Elements of the linked list:");
        displayLinkedList(list);

        //access elements at arbitrary positions
        int position = 2;
        try {
            int data = list.get(position);
            System.out.println("\nElement at position " + position + ": " + data);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    private static void displayLinkedList(LinkedList list) {
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

Main.main(null);

```

    Elements of the linked list:
    10 20 30 40 
    
    Element at position 2: 30



```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    //method to add a new node at the end of the linked list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // bubble Sort method
    public void bubbleSort() {
        if (head == null)
            return;

        boolean swapped;
        Node temp;
        do {
            swapped = false;
            Node prev = null;
            Node current = head;
            Node next = head.next;

            while (next != null) {
                if (current.data > next.data) {
                    if (prev != null)
                        prev.next = next;
                    else
                        head = next;

                    temp = next.next;
                    next.next = current;
                    current.next = temp;

                    prev = next;
                    next = current.next;
                    swapped = true;
                } else {
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(64);
        list.append(25);
        list.append(12);
        list.append(22);
        list.append(11);

        System.out.println("Linked list before sorting:");
        list.printList();

        list.bubbleSort();

        System.out.println("Linked list after sorting:");
        list.printList();
    }
}

LinkedList.main(null);
```

    Linked list before sorting:
    64 25 12 22 11 
    Linked list after sorting:
    11 12 22 25 64 

