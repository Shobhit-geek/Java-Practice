package basics.conditionalstmt;

import java.util.Scanner;

// Definition of Conditional Statement

// A conditional statement is a programming construct that allows a program to make decisions and execute different blocks of code based on whether a condition is true or false.
// In Java,conditional statements evaluate a boolean expression and run specific code depending on the result.

// Main Conditional Statements in Java
// 1. if
// Executes a block of code only if the condition is true.

// 2. if-else
// Executes one block when the condition is true and another block when it is false.

// 3. else-if ladder
// Used to check multiple conditions one by one.

// 4. switch
// Used when you want to choose one block of code from many possible options based on a value.

public class ifelse{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to check if its odd or even");
        int num = sc.nextInt();
        if(num%2 == 0){
            System.out.println("number is even");
        }else{
            System.out.println("number is odd");
        }

        // else-if example
        int marks = 72;

        if (marks >= 90) {
            System.out.println("Grade A");
        } 
        else if (marks >= 75) {
            System.out.println("Grade B");
        } 
        else if (marks >= 60) {
            System.out.println("Grade C");
        } 
        else if (marks >= 40) {
            System.out.println("Grade D");
        } 
        else {
            System.out.println("Fail");
        }
    }
}