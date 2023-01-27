package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        var l = score.length;
        var result = new String[l];
        var pos = Arrays.copyOf(score, l);
        Arrays.sort(pos);
        for (int i = 0; i < l; i++) {
            var t = (Arrays.binarySearch(pos, score[i]) - l) * (-1);
            switch (t) {
                case 1 -> result[i] = "Gold Medal";
                case 2 -> result[i] = "Silver Medal";
                case 3 -> result[i] = "Bronze Medal";
                default -> result[i] = t + "";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new RelativeRanks().findRelativeRanks(new int[]{10, 2, 3,});
    }
}
