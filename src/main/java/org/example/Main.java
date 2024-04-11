package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node { // created a node class to define elements of the linked list
    int data; // this stores integers
    Node next; // this is a pointer that points to the next list

    // Constructor to initialise the new node
    Node(int data) {
        this.data = data; // storing data
        this.next = null; // setting the next pointer to null
    }
}

class LinkedList { // this class helps us to manage things on the linked list
    Node head; // beginning of the list


    void insertEnd(int data) { //  this function helps us insert a new node
        Node newNode = new Node(data); // a new node is created
        if (head == null) {
            head = newNode; // if the list is empty, then make the head the new Node
        } else {
            Node last = head; //  start from the head
            while (last.next != null) {
                last = last.next;  //  going  to the last node
            }
            last.next = newNode;  //  inserting a new node towards the end
        }
    }


    int sum() { //  this function helps us to calculate the sum of the given nodes in the list
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data; // adding data of each node for addition
            current = current.next; // moving to another node
        }
        return sum; //  returning the sum
    }
}

public class Main { // this class checks if a given number is prime

    static boolean isPrime(int n) {
        if (n <= 1) return false; //  if a number is less than 2, it is not considered a prime number
        for (int i = 2; i <= Math.sqrt(n); i++) {  // checks if the number is divisible by any other number than 1 and itself
            if (n % i == 0) return false;
        }
        return true; //  the number is prime number
    }


    static boolean hasDigitThree(int n) { //  this method allows us to check if the number is 3 or not
        return String.valueOf(n).contains("3"); //  converting to string to see if the value is 3
    }

    public static void main(String[] args) {
        int nombre = 100; // Limit
        LinkedList PrimaryprimesList = new LinkedList(); // the list to store any prime numbers
        LinkedList primesWithThreeList = new LinkedList(); // list that stores prime numbers including 3



        for (int i = 2; i <= nombre; i++) { //  populating the list with prime numbers
            if (isPrime(i)) { // id the following number is a prime number, then add
                PrimaryprimesList.insertEnd(i);
                if (hasDigitThree(i)) { //  if the following contains the '3' digit, add to the other list
                    primesWithThreeList.insertEnd(i);
                }
            }
        }


        int PrimesWithThree = primesWithThreeList.sum(); // calculating the sum of num in the second list
        System.out.println("Sum of prime numbers containing digit '3' between 0 and " + nombre + ": " + PrimesWithThree);
    }
}