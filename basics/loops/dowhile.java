package basics.loops;

import java.util.Scanner;

// A do-while loop is a control flow statement that executes the loop body at least once,
// and then repeats execution as long as the condition remains true.

// Key point: The condition is checked after running the loop body(post-test loop).

public class dowhile {
    public static void main(String[] args) {
        int i = 1;

        do {
            System.out.println(i);
            i++;
        } while (i <= 5);
    }
}
