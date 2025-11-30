package Array.Sorting;

public class selectionSort {

    // The idea is - after each iteration, the smallest element in the unsorted part of the array
    // will be placed at the beginning of the unsorted part.
    // Time Complexity: O(n^2) in the worst and average case.
    // Space Complexity: O(1) (in-place sorting).
    public static void SelectionSort(int[] arr) {
        int n = arr.length;

        // Outer loop to iterate over each element in the array
        for (int i = 0; i < n - 1; i++) {
            int smallestIndex = i; // Assume the first element of the unsorted part is the smallest

            // Inner loop to find the smallest element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j; // Update the index of the smallest element
                }
            }

            // Swap the smallest element with the first element of the unsorted part
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2};
        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Call the selection sort function
        SelectionSort(arr);

        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Dry run example:
        /*
        Example Input: arr = {5, 3, 8, 6, 2}

        Pass 1:
        Find the smallest element in {5, 3, 8, 6, 2} -> Smallest = 2
        Swap 2 with 5 -> {2, 3, 8, 6, 5}

        Pass 2:
        Find the smallest element in {3, 8, 6, 5} -> Smallest = 3
        No swap needed -> {2, 3, 8, 6, 5}

        Pass 3:
        Find the smallest element in {8, 6, 5} -> Smallest = 5
        Swap 5 with 8 -> {2, 3, 5, 6, 8}

        Pass 4:
        Find the smallest element in {6, 8} -> Smallest = 6
        No swap needed -> {2, 3, 5, 6, 8}

        Final Output: {2, 3, 5, 6, 8}
        */
    }
}