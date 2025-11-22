package basics.loops;

public class breakcontinue {
    public static void main(String[] args) {
        // Example of 'break': Exits the loop when the condition is met
        System.out.println("Example of 'break':");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                // Breaks out of the loop when i equals 5
                break;
            }
            System.out.println(i);
        }

        // Example of 'continue': Skips the current iteration when the condition is met
        System.out.println("\nExample of 'continue':");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                // Skips the rest of the loop body for this iteration
                continue;
            }
            System.out.println(i);
        }
    }
}
