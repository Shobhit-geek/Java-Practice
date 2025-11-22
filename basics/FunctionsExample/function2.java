package basics.FunctionsExample;

public class function2 {

    public static void sum(int a, int b){
        int c = 15; // method scope
        System.out.println(a+b+c);
    }
    //method overloading - same method name but difference in datatypes of parameter or no. of parameter
    public static void sum(int a, int b, int d) {
        int c = 15; // method scope
        System.out.println(a + b + c + d);
    }
    // just changing the return type of the method will not help in overloading.
    // so below example will throw duplicate method error

    // public static int sum(int a, int b) {
    //     int c = 15; // method scope
    //     int sum = a+b+c;
    //     System.out.println(sum);
    //     return sum;
    // }
    
    public static void main(String[] args) {
        {
            // block scope
            int a = 0; 
            System.out.println(a);
        }
        sum(1,2);
        sum(1,2,3);
    }
}
