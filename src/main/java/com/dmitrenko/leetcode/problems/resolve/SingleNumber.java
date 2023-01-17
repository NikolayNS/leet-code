package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (min > m.getValue()) {
                min = m.getValue();
                result = m.getKey();
            }
        }

        return result;
    }
}
