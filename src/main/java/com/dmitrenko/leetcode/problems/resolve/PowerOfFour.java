package com.dmitrenko.leetcode.problems.resolve;

public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        var four = 4;
        for (int i = 0; i < 16; i++) {
            if(four == n) return true;
            four = four * 4;
        }

        return false;
    }
}
