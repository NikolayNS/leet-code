package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        var result = new ArrayList<Integer>();
        int up = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int left = 0;

        int i = 0;
        int l = matrix[0].length * matrix.length - 1;
        while (i < l) {
            for (int j = left; j <= right ; j++) {
                result.add(matrix[up][j]);
                i++;
            }
            up++;
            if (i >= l) break;
            for (int j = up; j <= down; j++) {
                result.add(matrix[j][right]);
                i++;
            }
            right--;
            if (i >= l) break;
            for (int j = right; j >= left; j--) {
                result.add(matrix[down][j]);
                i++;
            }
            down--;
            if (i >= l) break;
            for (int j = down; j >= up; j--) {
                result.add(matrix[j][left]);
                i++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
