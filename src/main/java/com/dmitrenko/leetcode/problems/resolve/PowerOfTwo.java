package com.dmitrenko.leetcode.problems.resolve;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;

        var s = 2;
        for (int i = 0; i < 32; i++) {
            if (s == n) return true;
            s = s * s;
        }

        return false;
    }

    public static void main(String[] args) {
        new PowerOfTwo().isPowerOfTwo(2);
    }
}
