package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        var arr = new int[]{1, 1, 2, 2, 3};
        System.out.println(new RemoveElement().removeElement(arr, 2));
        System.out.println(Arrays.toString(arr));
    }
}
