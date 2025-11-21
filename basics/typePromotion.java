package basics;

// Definition:Type promotion in Java refers to the automatic conversion of smaller data types to larger data types during operations to prevent data loss.

// When It Happens:
// 1. Type promotion occurs during arithmetic operations or method calls.
// 2. Smaller data types(e.g.,byte,short,char)are promoted to a larger data type(e.g.,int,long,float,double)to ensure compatibility.

// Rules of Type Promotion:
// 1. Operands in Expressions:If operands of different types are used in an expression,the smaller type is promoted to the larger type.
//     Example:
//     int a=10;double b=5.5;double result=a+b; // 'a' is promoted to double

// 2. byte,short,and char:These are always promoted to int during arithmetic operations,even if the result can fit in the smaller type.
//     byte b1=10,b2=20;int result=b1+b2; // Both b1 and b2 are promoted to int

// Promotion Hierarchy:The promotion follows this order:byte->short->int->long->float->double

public class typePromotion {

    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        short x = 12;
        int s = a+b+x; // this will work
        System.out.println(a + b + x); // output = 207 as all got converted to int

        long l= 2424243;
        double d = 20.242424;
        float f = 20.11f;

        double dd = l+d+f; // this will work
        System.err.println(l+d+f); // all got converted to double based on highest order
    }
}
