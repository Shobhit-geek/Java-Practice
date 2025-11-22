package basics.operators;

public class BitwiseDemo {
    public static void main(String[] args) {
        int a = 5; // 0101
        int b = 3; // 0011

        System.out.println(a & b); // AND
        System.out.println(a | b); // OR
        System.out.println(a ^ b); // XOR
        System.out.println(~a); // NOT
        System.out.println(a << 1); // left shift
        System.out.println(a >> 1); // right shift
        System.out.println(a >>> 1); // unsigned right shift
    }
}
