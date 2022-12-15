package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.Map;

public class MaxOccuringChar {

    public int maximumOccurringCharacter(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int i = 1;
        for (char c : chars) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, i);
            } else {
                map.put(c, count + 1);
            }
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        char c = ' ';
        char x = ' ';

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (max < m.getValue()) {
                max = m.getValue();
                c = m.getKey();
            }

            if (min > m.getValue()) {
                min = m.getValue();
                x = m.getKey();
            }
        }

        var y = map.get(c);
        var p = map.get(x);

        return y - p;
    }
}
