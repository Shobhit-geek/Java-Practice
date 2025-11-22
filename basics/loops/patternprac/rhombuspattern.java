package basics.loops.patternprac;

import java.util.Scanner;

/* pattern - 
********
*      *
*      *
********
*/
public class rhombuspattern {
    public static void rhombusPattern(int totRows, int totCol){
        for(int i=1;i<=totRows; i++){
            for(int j=1;j<=totCol; j++){
                if(i==1 || i==totRows || j==1 || j==totCol){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        rhombusPattern(rows, columns);
    }
}
