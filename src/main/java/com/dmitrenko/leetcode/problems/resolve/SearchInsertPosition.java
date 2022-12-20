package com.dmitrenko.leetcode.problems.resolve;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;
            var current = nums[middle];

            if (current == target) {
                return middle;
            } else if (current < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }
}
