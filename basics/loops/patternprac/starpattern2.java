package basics.loops.patternprac;
import java.util.Scanner;

/* Inverted Star Pattern
***
**
*
*/
public class starpattern2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=n-i;j>=0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}

