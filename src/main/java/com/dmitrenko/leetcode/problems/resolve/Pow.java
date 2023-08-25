package com.dmitrenko.leetcode.problems.resolve;

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) result = result * x;
            x = x * x;
            n = n / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0, 10));
    }
}
