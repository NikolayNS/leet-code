package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        var list = new ArrayList<Integer>();
        var max = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            list.add(num);
            if(map.get(num) > max) max = map.get(num);
        }
        var min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == max) {
                var c = list.lastIndexOf(m.getKey()) - list.indexOf(m.getKey()) + 1;
                if(c < min) min = c;
            }
        }
        return min;
    }
}
