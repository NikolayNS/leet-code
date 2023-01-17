package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        var set = new HashSet<Integer>();
        for (int j : nums1) {
            set.add(j);
        }

        var result = new ArrayList<Integer>();
        for (int j : nums2) {
            if (set.contains(j)) {
                result.add(j);
                set.remove(j);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
