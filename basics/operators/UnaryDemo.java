package basics.operators;

public class UnaryDemo {
    public static void main(String[] args) {
        int x = 7;
        boolean flag = false;

        System.out.println(+x);   // unary plus- Unary + is rarely used because it does not change the value.
        System.out.println(-x);   // unary minus- It negates the number.
        // Makes positive number → negative & Makes negative number → positive

        System.out.println(x++);  // post-increment
        System.out.println(++x);  // pre-increment
        System.out.println(x--);  // post-decrement
        System.out.println(--x);  // pre-decrement
        System.out.println(!flag); // logical NOT
    }
}

//output 
// 5 -5 5 7 7 5 true