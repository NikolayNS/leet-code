package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.Collections;

public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        var list = new ArrayList<Integer>();
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                j++;
            } else {
                list.add(j);
                j = 1;
            }
        }
        list.add(j);
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
