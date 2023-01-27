package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if(nums.length < 1) return 0;
        Arrays.sort(nums);
        int j = 1;
        for (int num : nums) {
            if (num == j) {
                j++;
            } else if (num > j) {
                return j;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
