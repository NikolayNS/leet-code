package com.dmitrenko.leetcode.problems;

public class EqualRowAndColumnPairs {

    public int equalPairs(int[][] grid) {
        var result = 0;

        var l = grid.length;
        for (int i = 0; i < l; i++) {
            var row = grid[i];
            for (int j = 0; j < l; j++) {
                boolean equal = true;
                for (int k = 0; k < l; k++) {
                    if (row[j] != grid[k][j]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) {
                    result++;
                }
            }
        }

        return result;
    }
}
