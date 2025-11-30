package Array;

import java.util.Scanner;

public class printSubarrays {
    // Subarray is a contiguous part of an array.
    // For example: [1, 2, 3, 4, 5] -> subarrays include [1, 2], [1], [2, 3], etc.

    public static void printsubArrays(int[] arr) {
        int n = arr.length;
        System.out.println("Printing all the subarrays");

        // Outer loop to fix the starting point of the subarray
        for (int i = 0; i < n; i++) {
            // Inner loop to fix the ending point of the subarray
            for (int j = i; j < n; j++) {
                // Loop to print elements of the current subarray
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                // Print a new line after each subarray
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the array
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        // Input the elements of the array
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            int ele = sc.nextInt();
            arr[i] = ele;
        }

        // Call the function to print all subarrays
        printsubArrays(arr);

        // Dry run example:
        /*
        Example Input:
        Array: [1, 2, 3]

        Dry Run:
        Outer loop (i = 0):
            Inner loop (j = 0): Subarray = [1]
            Inner loop (j = 1): Subarray = [1, 2]
            Inner loop (j = 2): Subarray = [1, 2, 3]
        Outer loop (i = 1):
            Inner loop (j = 1): Subarray = [2]
            Inner loop (j = 2): Subarray = [2, 3]
        Outer loop (i = 2):
            Inner loop (j = 2): Subarray = [3]
        */
    }
}
