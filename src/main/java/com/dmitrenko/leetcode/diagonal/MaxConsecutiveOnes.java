package com.dmitrenko.leetcode.diagonal;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                if (max < count) max = count;
                count = 0;
            }
        }
        if (count != 0 && max < count) max = count;
        return max;
    }
}
