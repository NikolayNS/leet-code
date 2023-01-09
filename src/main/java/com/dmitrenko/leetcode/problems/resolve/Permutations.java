package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] num) {
        var result = new ArrayList<List<Integer>>();
        if (num.length == 0) return result;

        if (num.length == 1) {
            result.add(List.of(num[0]));
            return result;
        }

        var fist = new ArrayList<Integer>();
        fist.add(num[0]);
        result.add(fist);
        for (int i = 1; i < num.length; i++) {
            var temp = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> r : result) {
                    var arr = new ArrayList<>(r);
                    arr.add(j, num[i]);
                    temp.add(arr);
                }
            }
            result = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 1, 3}));
    }
}
