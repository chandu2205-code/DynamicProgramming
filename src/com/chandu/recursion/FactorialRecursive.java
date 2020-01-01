package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Recursive factorial
 */
public class FactorialRecursive {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int factorial = factorial(number);
        System.out.println(String.format("Factorial of %d is %d",number,factorial));

    }

    private static int factorial(int number) {
        if(number == 0 || number == 1) return number;
        return number*factorial(number-1);
    }
}
