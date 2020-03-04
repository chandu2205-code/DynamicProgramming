package com.chandu.rawat.dp;

/**
 * Given an array of integers , find subarray which has maximum sum
 * And find start and end index where subarray ends
 * Kadane's Algorithm (DP)
 * @author allenkis
 */
public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] array = new int[]{-2,-3,4,-1,-2,1,5,-3};
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int beginIndex = 0;
        int endIndex = 0;

        for (int i=0;i<array.length;i++) {
            maxEndingHere+=array[i];
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
                beginIndex = i+1;
            }
            if(maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                endIndex = i;
            }
        }

        System.out.println(String.format("Maximum subarray sum is %s starting from index %s to %s",maxSoFar,beginIndex,endIndex));
    }
}
