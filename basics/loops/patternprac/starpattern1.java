package basics.loops.patternprac;
import java.util.Scanner;
/*
pattern-
*
**
***
*/

public class starpattern1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // First loop for number of rows in the star pattern
        for (int i = 1; i <= n; i++) {
            // second loop for no. of * in each row - here i = no. of star
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}