package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            map.merge(n, 1, Integer::sum);
        }
        var max = 0;
        for (Integer m : map.keySet()) {
            if (map.containsKey(m + 1)) {
                max = Math.max(max, map.get(m) + map.get(m + 1));
            }
        }
        return max;
    }
}
