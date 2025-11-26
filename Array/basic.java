package Array;

import java.util.Scanner;

public class basic {
    public static void main(String args[]) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 Elements in the array:");
        for(int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The elements in the array are:");
        for(int i: arr) {
            System.err.println("Element: " + i);
        }
        sc.close();
    }
}
