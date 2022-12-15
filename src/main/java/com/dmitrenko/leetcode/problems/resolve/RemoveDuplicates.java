package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        var arr = new int[]{1, 1, 2, 2, 3};
        System.out.println(new RemoveDuplicates().removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
