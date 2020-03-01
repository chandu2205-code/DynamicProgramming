package com.chandu.rawat.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Find length of longest substring of a given string of digits,
 * such that sum of digits in the first half and second half
 * of the substring is same . Example :
 * Input : 142124
 * Output : 6
 * Input : 9430723
 * Output : 4
 * Algorithm : Below uses DP[Memoization] as it has overlapping sub problems
 * Time complexity : O(n*n)
 * @author allenkis
 */
public class LongestSubstringWithDigits {

    static int[][] sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        sum = new int[length][length];
        //Fill all diagonal elements
        for(int i=0;i<length;i++) {
            sum[i][i] = Integer.parseInt(input.substring(i,i+1));
        }
        //Fill substring length , (i<j -- doesn't have any sense) -- can optimize space
        for(int i=0;i<length;i++) {
            for(int j=i+1;j<length;j++) {
                sum[i][j] = sum[i][j-1] + Integer.parseInt(input.substring(j,j+1));
            }
        }
        //Print max Length
        System.out.println(maxLengthSubstring(sum, input));
    }

    /**
     * Prints max Length substring whose sum of digits in first half is equal to second half
     * @param sum
     * @param input
     * @return
     */
    public static int maxLengthSubstring(int[][] sum, String input) {

        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<input.length();i++) {
            for(int j=i+1;j<input.length();j++) {
                int subStringLength = j-i+1;
                if(!isEvenLength(subStringLength)) {
                    continue;
                }
                int k = subStringLength/2;

                if((subStringLength > maxLength) && (sum[i][i+k-1] == sum[i+k][j])) {
                    maxLength = subStringLength;
                }
            }
        }
        return maxLength;
    }

    private static boolean isEvenLength(int subStringLength) {
        return (subStringLength)%2 == 0 ? true : false;
    }
}
