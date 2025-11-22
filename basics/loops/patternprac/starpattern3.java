package basics.loops.patternprac;

import java.util.Scanner;

/*
pattern - 
  *
 **
***
*/
public class starpattern3 {
    public static void starPattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        starPattern(n);
    }
}
