package com.dmitrenko.leetcode.problems.resolve;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            sum += num;
        }
        double max = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum / k);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }


}
