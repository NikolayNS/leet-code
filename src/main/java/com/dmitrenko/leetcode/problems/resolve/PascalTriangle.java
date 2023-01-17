package com.dmitrenko.leetcode.problems.resolve;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        var result = new LinkedList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            var arr = new LinkedList<Integer>();

            for (int j = 0; j < i + 1; j++) {
                arr.add(j == 0 || j == i
                    ? 1
                    : result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }

            result.add(arr);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(5));
    }
}
