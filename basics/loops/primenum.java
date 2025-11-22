package basics.loops;

import java.util.Scanner;

public class primenum {
    // Prime number → A number that has only 2 factors: 1 and itself.
    // Examples: 2, 3, 5, 7, 11, etc.

    // Efficient way to check for prime:
    // Instead of checking divisibility from 2 to n-1, we check only up to √n.
    // This reduces the number of iterations and improves performance.

    public static boolean prime(int num) {
        // Loop from 2 to √num
        for (int i = 2; i <= Math.sqrt(num); i++) {
            // If num is divisible by any number in this range, it is not prime
            if (num % i == 0) {
                return true; // Not a prime number
            }
        }
        // If no divisors are found, the number is prime
        return false;
    }

    public static void main(String[] args) {
        // Prompt the user to enter a number
        System.out.println("Enter a number to check if it is prime: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // Call the prime function to check if the number is prime
        boolean result = prime(num);

        // Print the result
        System.out.println("Is this number prime? " + result);
    }
}
