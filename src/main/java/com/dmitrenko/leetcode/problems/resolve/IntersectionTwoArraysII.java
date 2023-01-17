package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IntersectionTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        var map1 = new HashMap<Integer, Integer>();
        var map2 = new HashMap<Integer, Integer>();

        for (Integer i : nums1) {
            map1.merge(i, 1, Integer::sum);
        }
        for (Integer i : nums2) {
            map2.merge(i, 1, Integer::sum);
        }

        var list = new LinkedList<Integer>();
        for (Map.Entry<Integer, Integer> m : map1.entrySet()) {
            if (map2.containsKey(m.getKey())) {
                for (int i = 0; i < Math.min(m.getValue(), map2.get(m.getKey())); i++) {
                    list.add(m.getKey());
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
