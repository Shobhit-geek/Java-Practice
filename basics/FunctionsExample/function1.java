package basics.FunctionsExample;

import java.util.Scanner;

// In Java:
// ➡Function inside a class=Method
// People still use the word function,but the correct Java term is method.

// Definition of a Method
// A method in Java is a block of code that performs a specific task and can be executed when called.

// Why use methods?
// ✔Code reuse ✔Clean,modular code ✔Easy debugging ✔Avoids repetition ✔Improves readability

// returnType methodName(parameterList) {
//     // method body
// }
public class function1 {
    // Parameters are the variables defined in the method signature. 
    // They act as placeholders for the values that the method will receive when it is called.
    public static void isEvenorOdd(int num){ //parameters or formal parameters -
        if(num%2 == 0){
            System.out.println("Number is even");
        }else{
            System.out.println("Number is oddd");
        }
    }
    public static void main(String[] args) {
        System.out.println("enter a number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //  Arguments are the actual values or expressions passed to the method when it is called.
        //  These values are assigned to the corresponding parameters.
        isEvenorOdd(n); // Arguments or Actual Arguments- value passed to the function
    }
}
