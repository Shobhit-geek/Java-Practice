package basics.loops;

import java.util.Scanner;

public class forloop {
    public static void main(String[] args) {
        // print table
        System.out.println("Enter a number to print table: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i=1; i<11;i++){
            System.out.println(a+" x "+i+" = "+ a*i);
        }
    }
}
