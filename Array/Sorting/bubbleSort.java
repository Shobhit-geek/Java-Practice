package Array.Sorting;

public class bubbleSort {

    // Bubble Sort Algorithm:
    // Bubble Sort is a simple sorting algorithm that repeatedly steps through the list,
    // compares adjacent elements, and swaps them if they are in the wrong order.
    // This process is repeated until the list is sorted.
    // Time Complexity: O(n^2) in the worst and average case, O(n) in the best case (already sorted array).
    // Space Complexity: O(1) (in-place sorting. In-place sorting means:Sorting the array without using extra significant memory.)
    public static void bubbleSortt(int[] arr) {
        int n = arr.length;

        // Outer loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // To optimize and stop if the array is already sorted

            // Inner loop for comparing adjacent elements
            // After every iteration of 'i', the largest element in the unsorted part of the array
            // will move to its correct position at the end. That's why the inner loop runs only till 'n-i-1'. 
            // For example, when i=1,the inner loop will run till 'n-1-1' as the largest element is already at the last position.
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap the elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Mark that a swap occurred
                }
            }

            // If no swaps occurred in this pass, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2};

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Call the bubble sort function
        bubbleSortt(arr);

        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Dry run example:
        /*
        Example Input: arr = {5, 3, 8, 6, 2}

        Pass 1:
        Compare 5 and 3 -> Swap -> {3, 5, 8, 6, 2}
        Compare 5 and 8 -> No Swap -> {3, 5, 8, 6, 2}
        Compare 8 and 6 -> Swap -> {3, 5, 6, 8, 2}
        Compare 8 and 2 -> Swap -> {3, 5, 6, 2, 8}

        Pass 2:
        Compare 3 and 5 -> No Swap -> {3, 5, 6, 2, 8}
        Compare 5 and 6 -> No Swap -> {3, 5, 6, 2, 8}
        Compare 6 and 2 -> Swap -> {3, 5, 2, 6, 8}

        Pass 3:
        Compare 3 and 5 -> No Swap -> {3, 5, 2, 6, 8}
        Compare 5 and 2 -> Swap -> {3, 2, 5, 6, 8}

        Pass 4:
        Compare 3 and 2 -> Swap -> {2, 3, 5, 6, 8}

        Final Output: {2, 3, 5, 6, 8}
        */
    }
}
