package basics.conditionalstmt;
import java.util.Scanner;

class SwitchDemo {
    // You can use expressions inside a switch, but the expression must evaluate to a single
    //  value (constant or variable value), not a boolean condition like >=,<=, or ranges.
    
    // Java does not allow relational or logical expressions inside case labels.
    // case(marks>=90): // ❌ Not allowed
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to check if its odd or even");
        int num = sc.nextInt();
        switch (num % 2) {
            case 0:
                System.out.println(num + " is even");
                break;
            case 1:
            case -1:
                System.out.println(num + " is odd");
                break;
            default:
                break;
        }
        sc.close();
    }
}
