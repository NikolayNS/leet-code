package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int missing = 0;
        for (int num : nums) {
            if (num != missing) {
                break;
            }
            missing++;
        }

        return missing;
    }
}
