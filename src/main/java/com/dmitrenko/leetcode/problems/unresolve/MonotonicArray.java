package com.dmitrenko.leetcode.problems.unresolve;

public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        var l = nums.length;
        if(l == 1) return true;
        var k = true;
        var m = true;
        for (int i = 1; i < l; i++) {
            k = nums[i - 1] <= nums[i];
            m = nums[i - 1] >= nums[i];
        }
        return k != m;
    }
}
