package com.dmitrenko.leetcode.problems.company;

public class SpiralMatrixFromArray {

    public void form(int[] arr, int[][] matrix) {
        int up = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int left = 0;

        int i = 0;
        int l = matrix[0].length * matrix.length;
        while (i < l) {
            for (int j = left; j <= right ; j++) {
                matrix[up][j] = arr[i];
                i++;
            }
            up++;
            for (int j = up; j <= down; j++) {
                matrix[j][right] = arr[i];
                i++;
            }
            right--;
            for (int j = right; j >= left; j--) {
                matrix[down][j] = arr[i];
                i++;
            }
            down--;
            for (int j = down; j >= up; j--) {
                matrix[j][left] = arr[i];
                i++;
            }
            left++;
        }
    }
}
