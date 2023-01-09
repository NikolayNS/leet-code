package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        var set = new HashSet<List<Integer>>();

        var fist = new ArrayList<Integer>();
        fist.add(nums[0]);
        set.add(fist);
        for (int i = 1; i < nums.length; i++) {
            var temp = new HashSet<List<Integer>>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> r : set) {
                    var arr = new ArrayList<>(r);
                    arr.add(j, nums[i]);
                    temp.add(arr);
                }
            }
            set = temp;
        }

        return new ArrayList<>(set);
    }
}
