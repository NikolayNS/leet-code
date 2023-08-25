package com.dmitrenko.leetcode.problems;

public class NumberOfLinesToWriteString {

    public int[] numberOfLines(int[] widths, String s) {
        var lines = 1;
        var count = 0;

        for (int i = 0; i < s.length(); i++) {
            var sum = widths[s.charAt(i) - 'a'];
            if (count + sum > 100) {
                lines++;
                count = sum;
            } else {
                count += sum;
            }
        }

        return new int[]{lines, count};
    }
}