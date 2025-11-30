package Array;

import java.util.Scanner;

public class binarysearch {
    // Binary search is an optimal way of searching an element in a sorted array.
    // It works by repeatedly dividing the search interval in half.
    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    public static int binary(int[] arr, int searchEle) {
        // Initialize the start and end pointers
        int start = 0;
        int end = arr.length - 1;

        // Loop until the search interval is valid
        while (start <= end) {
            // Calculate the middle index
            int mid = (start + end) / 2;

            // Check if the middle element is the search element
            if (searchEle == arr[mid]) {
                return mid; // Element found, return its index
            } else if (searchEle > arr[mid]) {
                // If the search element is greater, narrow the search to the right half
                start = mid + 1;
            } else {
                // If the search element is smaller, narrow the search to the left half
                end = mid - 1;
            }
        }

        // If the element is not found, return -1
        return -1;
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

        // Input the element to be searched
        System.out.println("Enter the element to be searched: ");
        int srch = sc.nextInt();

        // Call the binary search function
        int result = binary(arr, srch);

        // Output the result
        if (result == -1) {
            System.out.println("Element is not found in the array");
        } else {
            System.out.println("Element is found in the array at index: " + result);
        }
        sc.close();
    }
}
