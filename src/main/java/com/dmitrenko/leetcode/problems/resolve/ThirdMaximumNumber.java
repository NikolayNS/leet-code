package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        var l = nums.length;
        if (l == 1) return nums[0];
        if (l == 2) return nums[1];

        var max = nums[l -1];
        var count = 0;
        for (int i = l - 2; i >= 0 || count < 3; i--) {
            if (max != nums[i]) {
                max = nums[i];
                count++;
            }
        }
        if (count != 3) return nums[l - 1];

        return max;
    }
}
