package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class ConvertIntegerToTheSum {

    public int[] getNoZeroIntegers(int n) {
        return get(n - 1, 1);
    }

    private int[] get(int n, int k) {
        if (check(n) || check(k)) return get(n - 1, k + 1);
        return new int[]{n, k};
    }

    private boolean check(int n) {
        int c = n;
        while (c != 0) {
            if (c % 10 == 0) return true;
            c = c / 10;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConvertIntegerToTheSum().getNoZeroIntegers(11)));
    }
}
