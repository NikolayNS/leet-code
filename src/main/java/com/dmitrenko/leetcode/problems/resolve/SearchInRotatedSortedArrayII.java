package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        var i = Arrays.binarySearch(nums, target);
        System.out.println(i);
        return i > 0;
    }

    public static void main(String[] args) {
        new SearchInRotatedSortedArrayII().search(new int[]{2,5,6,0,0,1,2}, 3);
    }
}
