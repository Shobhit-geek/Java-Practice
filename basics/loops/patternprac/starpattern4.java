package basics.loops.patternprac;

import java.util.Scanner;

/* pattern(Diamond)
  *
 ***
*****
 ***
  *
*/
public class starpattern4 {

    public static void starPattern(int n) {
        // Upper part of the diamond
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower part of the diamond
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows for the diamond pattern: ");
        int n = sc.nextInt();
        starPattern(n);
        sc.close(); // Close the scanner to prevent resource leaks
    }
}
