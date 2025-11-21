package basics;

// Definition:Typecasting is the process of converting one data type into another.It is commonly used when you need to perform operations between different data types.

// Types of Typecasting:
// Implicit Typecasting(Widening):
// Automatically performed by the compiler when converting a smaller data type to a larger data type.Example:int to long,float to double.
// Explicit Typecasting(Narrowing):
// Manually performed by the programmer when converting a larger data type to a smaller data type.Example:double to int,long to short.

// Widening(Implicit):
// Safe because there is no data loss.Example:byte->short->int->long->float->double.
// Narrowing(Explicit):
// Risky because it may lead to data loss or precision loss.Example:double->float->long->int->short->byte.

public class typeCasting {
    public static void main(String[] args){
        int num = 10;
        double result = num; // Implicit typecasting
        System.out.println("Implicit Typecasting = result: " + result);

        double num2 = 10.5;
        int result2 = (int) num2; // Explicit typecasting
        System.out.println("result2: " + result2);

        char ch ='A';
        int ascii = (int) ch; // Explicit typecasting
        System.out.println("ascii result: " + ascii);
    }
}
