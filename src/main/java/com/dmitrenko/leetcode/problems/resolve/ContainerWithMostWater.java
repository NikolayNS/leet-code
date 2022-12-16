package com.dmitrenko.leetcode.problems.resolve;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        var left = 0;
        var right = height.length - 1;

        var max = 0;

        while (left <= right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
