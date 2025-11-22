package basics.loops;

import java.util.Scanner;

public class reversenum {
	public static void main(String[] args) {
        System.out.println("Enter a number to print its reverse: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int rem = 0;
        int rev = 0;

        // Step 1: Loop until the number becomes 0
        while (num > 0) {
            // Step 2: Get the last digit (remainder when divided by 10)
            rem = num % 10;

            // Step 3: Remove the last digit from the number (integer division by 10)
            num = num / 10;

            // Step 4: Add the digit to the reversed number (shift existing digits left by multiplying by 10)
            rev = rev * 10 + rem;
        }

        // Step 5: Print the reversed number
        System.out.println("Reverse of the number is: " + rev);
    }
}
