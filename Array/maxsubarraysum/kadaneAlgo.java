package Array.maxsubarraysum;

public class kadaneAlgo {

    // Kadane's Algorithm:
    // This algorithm is used to find the maximum sum of a contiguous subarray in an array.
    // It works by maintaining two variables:
    // 1. currSum: Tracks the sum of the current subarray.
    // 2. maxSum: Tracks the maximum sum encountered so far.
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    // In short: If your running sum i.e, currentSum goes negative, throw it away and start fresh.
    // Because: A negative currentSum will only reduce the sum of any future subarray.
    // So instead of keeping it, Kadane’s algorithm resets currentSum to the current element.

    public static void kadanes(int[] arr) {
        int currSum = 0; // Initialize the current subarray sum to 0
        int maxSum = Integer.MIN_VALUE; // Initialize the maximum sum to the smallest possible value

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i]; // Add the current element to the current subarray sum

            // If the current subarray sum becomes negative, reset it to 0
            if (currSum < 0) {
                currSum = 0;
            }

            // Update the maximum sum if the current subarray sum is greater
            maxSum = Math.max(maxSum, currSum);
        }

        // Print the maximum subarray sum
        System.out.println("The maxSubarray sum is: " + maxSum);

        // Dry run example:
        /*
        Example Input: arr = {-2, -3, 4, -1, -2, 1, 5, -3}

        Step-by-step Execution:
        i = 0, currSum = -2, maxSum = -2 (currSum < 0, so reset currSum to 0)
        i = 1, currSum = -3, maxSum = -2 (currSum < 0, so reset currSum to 0)
        i = 2, currSum = 4, maxSum = 4
        i = 3, currSum = 3, maxSum = 4
        i = 4, currSum = 1, maxSum = 4
        i = 5, currSum = 2, maxSum = 4
        i = 6, currSum = 7, maxSum = 7
        i = 7, currSum = 4, maxSum = 7

        Final Output: The maxSubarray sum is: 7
        */
    }

    public static void main(String[] args) {
        // Example array
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        // Call Kadane's algorithm to find the maximum subarray sum
        kadanes(arr);
    }
}
