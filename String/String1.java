package String;

import java.util.Scanner;

public class String1 {
    public static void main(String[] args) {
        // STRINGS ARE IMMUTABLE
        // 3 ways to create a String in Java:

        // 1. Using a character array
        char[] name = {'S', 'U', 'B', 'H'}; // Strings can be created by combining characters in an array

        // 2. Using the 'new' keyword
        String str = new String("Shobhit"); // Creates a new String object explicitly

        // 3. By directly assigning a string literal
        String str1 = "Shobhit"; // Most commonly used method, creates a string literal in the string pool

        //TAKING STRING FROM INPUT
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String str2 = sc.next();
        // Example: Input: "John Doe"
        // Output: "Your name is: John"
        // Explanation: The next() method reads only the first word ("John") and stops
        // at the space. So use nexLine() as it will read whole sentence from input

        System.out.println("Your name is: " + str2);
        String str3 = sc.nextLine();
        System.out.println(str3);
        sc.close();
        
        //String has length() function which will help to give length of the string
        System.out.println("Length of word"+ str.length());  // This is String concatenation using + operator

        // charAt() method - used to get the caracter presen at speciic index of string
        for(int i=0; i<str1.length();i++){
            System.out.print(str1.charAt(i)+" "); 
        }
    }

}
