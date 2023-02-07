package com.dmitrenko.leetcode.problems.resolve;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        var numsOfRepeat = new int[nums.length + 1];
        var result = new int[2];
        int missNum = 0;
        for (int i = 0; i < nums.length; i++){
            missNum = missNum + (i + 1);
            numsOfRepeat[nums[i]] += 1;
            if (numsOfRepeat[nums[i]] == 2) {
                result[0] = nums[i];
            } else {
                missNum -= nums[i];
            }
        }
        result[1] = missNum;
        return result;
    }
}
