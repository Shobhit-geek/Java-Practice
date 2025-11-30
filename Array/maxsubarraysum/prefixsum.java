package Array.maxsubarraysum;
import java.util.Scanner;

// Maxsubarraysum is the problem in which we find the subarray of the array with the maximum sum.
// There are 3 approaches to solve this problem:
// 1. Brute force approach (O(n^3)): Calculate the sum of all subarrays using nested loops.
// 2. Prefix sum approach (O(n^2)): Use a prefix sum array to calculate subarray sums efficiently.
// 3. Kadane's algorithm (O(n)): Find the maximum subarray sum in linear time.
public class prefixsum {

    public static void subArray(int[] arr) {
        // Calculate the prefixSum array
        int start = 0;
        int end = arr.length;
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible value
        int currSum = 0; // Variable to store the current subarray sum
        int[] prefixSum = new int[end]; // Array to store prefix sums

        // Step 1: Compute the prefixSum array
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i] = (i == 0) ? arr[i] : prefixSum[i - 1] + arr[i]; // Add current element to the previous prefix sum
        }

        // Step 2: Print the prefixSum array (for debugging purposes)
        for (int i = 0; i < arr.length; i++) {
            System.out.println("PrefixSum[" + i + "] = " + prefixSum[i]);
        }

        // Step 3: Calculate the maximum subarray sum using the prefixSum array
        for (int i = 0; i < arr.length; i++) {
            start = i; // Start index of the subarray
            for (int j = i; j < arr.length; j++) {
                end = j; // End index of the subarray
                // Calculate the sum of the subarray using the prefixSum array
                currSum = (start == 0) ? prefixSum[end] : prefixSum[end] - prefixSum[start - 1];
                // Update maxSum if the current subarray sum is greater
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        // Step 4: Print the maximum subarray sum
        System.out.println("The max subarray sum is: " + maxSum);
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

        // Call the subArray function
        subArray(arr);
        sc.close(); // Close the scanner to prevent resource leaks
    }
}
