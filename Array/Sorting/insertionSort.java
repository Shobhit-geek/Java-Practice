package Array.Sorting;

public class insertionSort {

    // Insertion Sort Algorithm:
    // Insertion Sort is a simple sorting algorithm that builds the sorted array one element at a time.
    // It picks an element from the unsorted part and places it in its correct position in the sorted part.
    // Time Complexity: O(n^2) in the worst and average case, O(n) in the best case (already sorted array).
    // Space Complexity: O(1) (in-place sorting).

    public static void insertionSortt(int[] arr) {
        int n = arr.length;

        // Outer loop to iterate over each element in the array
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // The element to be inserted into the sorted part
            int j = i - 1;

            // Move elements of the sorted part that are greater than the key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the key in its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2}; // Example array

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Call the insertion sort function
        insertionSortt(arr);

        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Dry run example:
        /*
        Example Input: arr = {5, 3, 8, 6, 2}

        Pass 1:
        Key = 3, Compare with 5 -> Shift 5 -> Insert 3 -> {3, 5, 8, 6, 2}

        Pass 2:
        Key = 8, Compare with 5 -> No Shift -> {3, 5, 8, 6, 2}

        Pass 3:
        Key = 6, Compare with 8 -> Shift 8 -> Insert 6 -> {3, 5, 6, 8, 2}

        Pass 4:
        Key = 2, Compare with 8 -> Shift 8, Compare with 6 -> Shift 6,
        Compare with 5 -> Shift 5, Compare with 3 -> Shift 3 -> Insert 2 -> {2, 3, 5, 6, 8}

        Final Output: {2, 3, 5, 6, 8}
        */
    }
}
