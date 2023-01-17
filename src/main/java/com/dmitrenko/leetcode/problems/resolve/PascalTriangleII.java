package com.dmitrenko.leetcode.problems.resolve;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        var result = new LinkedList<List<Integer>>();

        for (int i = 0; i < rowIndex + 1; i++) {
            var arr = new LinkedList<Integer>();

            for (int j = 0; j < i + 1; j++) {
                arr.add(j == 0 || j == i
                    ? 1
                    : result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }

            result.add(arr);
        }

        return result.get(rowIndex - 1);
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangleII().getRow(5));

    }
}
