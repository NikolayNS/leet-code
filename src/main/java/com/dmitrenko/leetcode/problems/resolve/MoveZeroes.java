package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        var count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        int[] s = new int[]{0, 1, 2, 0, 13};
        new MoveZeroes().moveZeroes(s);
        System.out.println(Arrays.toString(s));
    }
}
