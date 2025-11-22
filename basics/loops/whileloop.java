package basics.loops;

import java.util.Scanner;

public class whileloop{
    public static void main(String[] args) {
        System.out.println("Enter a number to print table: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int i=1;
        while(i<11){
            System.out.println(a + " x " + i + " = " + a * i);
            ++i;
        }
    }
}