package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }
        int result = -1;
        int max = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (max < m.getValue()) {
                max = m.getValue();
                result = m.getKey();
            }
        }

        return result;
    }
}
