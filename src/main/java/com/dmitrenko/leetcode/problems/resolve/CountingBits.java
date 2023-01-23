package com.dmitrenko.leetcode.problems.resolve;

public class CountingBits {

    public int[] countBits(int n) {
        var result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            var chars = Integer.toBinaryString(i).toCharArray();

            var num = 0;
            for (int j = 0; j < chars.length; j++) {
                num = num + Integer.parseInt(chars[j] + "");
            }
            result[i] = num;
        }

        return result;
    }
}
