package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        var temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int max = temp[temp.length - 1];
        int ind = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == max) ind = i;
            if (nums[i] != max && nums[i] * 2 > max) {
                return -1;
            }
        }
        return ind;
    }
}
