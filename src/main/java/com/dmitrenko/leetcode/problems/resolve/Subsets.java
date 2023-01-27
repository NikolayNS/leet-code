package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>());
        for (int num : nums) {
            int size = matrix.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(matrix.get(j));
                list.add(num);
                matrix.add(list);
            }
        }
        return matrix;
    }
}
