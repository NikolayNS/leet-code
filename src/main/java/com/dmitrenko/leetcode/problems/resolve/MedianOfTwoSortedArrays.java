package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var temp = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, temp, 0, nums1.length);
        System.arraycopy(nums2, 0, temp, nums1.length, nums2.length);
        Arrays.sort(temp);
        var l = temp.length;
        return temp.length % 2 == 0 ? (double) (temp[l / 2 - 1] + temp[l / 2]) / 2 : temp[l / 2];
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
