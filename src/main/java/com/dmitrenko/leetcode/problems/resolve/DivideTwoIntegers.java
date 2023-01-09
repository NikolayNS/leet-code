package com.dmitrenko.leetcode.problems.resolve;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        var negative = ((dividend < 0) ^ (divisor < 0));
        var ans = math(dividend, divisor);

        if (negative) ans = -ans;

        return ans < Integer.MIN_VALUE
            ? Integer.MIN_VALUE
            : ans > Integer.MAX_VALUE
            ? Integer.MAX_VALUE
            : (int) ans;
    }

    private long math(long dividend, int divisor) {
        if (dividend < 0 && divisor < 0) return math(-dividend, -divisor);
        if (dividend < 0) return math(-dividend, divisor);
        if (divisor < 0) return math(dividend, -divisor);

        var count = 0L;
        while (dividend >= divisor) {
            count++;
            dividend = dividend - divisor;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(2147483647, 2));
    }
}
