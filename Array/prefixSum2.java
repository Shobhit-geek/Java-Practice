package Array;

// divide the array into 2 subarray with equal sum
// we will use prefix sum method
public class prefixSum2 {

    static int[] prefixSumFunc(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = arr[0];
        for(int i=1;i<arr.length; i++) {
            result[i] = result[i-1] + arr[i];
        }
        return result;
    }
    
    static boolean canDivideIntoEqualSumSubarrays(int[] prefixSum) {
        int totalSum = prefixSum[prefixSum.length - 1];
        int halfSum = totalSum / 2;
        for(int i: prefixSum) {
            if(i == halfSum) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 6, 3, 1};
        int[] prefixSumArray = prefixSumFunc(arr);
        if (canDivideIntoEqualSumSubarrays(prefixSumArray)) {
            System.out.println("The array can be divided into two subarrays with equal sum.");
        } else {
            System.out.println("The array cannot be divided into two subarrays with equal sum.");
        }   
    }
}
