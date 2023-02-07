package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class MaximumProductofThreeNumbers {

    public int maximumProduct(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        var l = nums.length;
        return Math.max(nums[l - 1] * nums[l - 2] * nums[l - 3], nums[l - 1] * nums[0] * nums[1]);
    }
}
