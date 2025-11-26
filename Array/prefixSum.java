package Array;

public class prefixSum {
    
    static int[] prefixSumFunc(int[] arr){
        int[] result = new int[arr.length];
        result[0] = arr[0];
        for(int i=1;i<arr.length; i++){
            result[i] = result[i-1] + arr[i];
        }

        return result;
    }
    public static void main(String[] args){

        int[] arr = {1,3,6,8,9};
        int[] psArray = prefixSumFunc(arr);
        System.out.println("The prefix sum array is:");
        for(int i : psArray){
            System.out.println(i);
        }
    }
}