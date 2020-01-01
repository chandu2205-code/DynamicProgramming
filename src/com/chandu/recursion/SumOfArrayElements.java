package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an array of integers write a recursive function that add
 * sum of all previous numbers to each index of array . For example
 * <ul>
 *     <li><b>Input : </b>1,2,3,4,5</li>
 *     <li><b>Output: </b>1,3,6,10,15</li>
 * </ul>
 */
public class SumOfArrayElements {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());
        int[] inputArray = new int[arraySize];
        for(int i=0;i<arraySize;i++) {
            inputArray[i] = Integer.parseInt(br.readLine());
        }
        int[] outputArray = calculatePrefixSum(1, inputArray);
        System.out.println("Prefix sum of number : "+Arrays.toString(outputArray));
    }

    private static int[] calculatePrefixSum(int index, int[] inputArray) {

        if(index >= inputArray.length ) return inputArray;
        inputArray[index] +=inputArray[index-1];
        calculatePrefixSum(++index, inputArray);
        return inputArray;
    }
}
