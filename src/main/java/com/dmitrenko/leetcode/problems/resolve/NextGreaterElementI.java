package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[j] < nums2[k]) {
                            result[i] = nums2[k];
                            break;
                        }
                    }
                    if (result[i] == 0) result[i] = -1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }
}
