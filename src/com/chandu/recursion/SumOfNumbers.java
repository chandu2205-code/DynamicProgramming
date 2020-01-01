package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Thumb Rules for Recursion :
 * 1 . Have terminating condition
 * 2 . Recursive function performs some part of task and delegate rest of it
 */
public class SumOfNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int sum = recursiveSum(number);
        System.out.println(String.format("Sum of first %d numbers is : %d",number,sum));
    }

    private static int recursiveSum(int number) {
        if(number == 0 || number == 1) return  number;
        return number+recursiveSum(number-1);
    }
}
