package com.dmitrenko.leetcode.problems.resolve;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        var matrix = new int[n][n];
        int up = 0;
        int right = n - 1;
        int down = n - 1;
        int left = 0;

        int i = 1;
        int l = n * n;
        while (i <= l) {
            for (int j = left; j <= right ; j++) {
                matrix[up][j] = i;
                i++;
            }
            up++;
            if (i > l) break;
            for (int j = up; j <= down; j++) {
                matrix[j][right] = i;
                i++;
            }
            right--;
            if (i > l) break;
            for (int j = right; j >= left; j--) {
                matrix[down][j] = i;
                i++;
            }
            down--;
            if (i > l) break;
            for (int j = down; j >= up; j--) {
                matrix[j][left] = i;
                i++;
            }
            left++;
        }

        return matrix;
    }
}
