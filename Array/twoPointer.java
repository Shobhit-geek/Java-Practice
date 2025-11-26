package Array;

public class twoPointer {
    
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortZeroesAndOnes(int[] arr) {
        int left = 0, right = arr.length - 1;
        while(left<right){
            if(arr[left] == 0) {
                left++;
            }
            else if(arr[right] == 1) {
                right--;
            }
            else{
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    }

        public static void main(String[] args) {
            int[] initialArray = new int[]{0,0,1,1,0,1,1,0,1};
            System.out.println("Initial Array:");
            for(int i : initialArray) {
                System.out.print(i + " ");
            }
            sortZeroesAndOnes(initialArray);
            System.out.println("\nSorted Array:");
            for(int i : initialArray) {
                System.out.print(i + " ");
            }
        }
}
