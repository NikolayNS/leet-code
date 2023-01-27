package com.dmitrenko.leetcode.problems.unresolve;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < word1.length(); i++) {
            map1.merge(word1.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < word2.length(); i++) {
            map2.merge(word2.charAt(i), 1, Integer::sum);
        }

        var count = 0;
        for (Map.Entry<Character, Integer> m : map1.entrySet()) {
            var value1 = m.getValue();
            var value2 = map2.getOrDefault(m.getKey(), 0);
            count += Math.max(value1, value2) - Math.min(value1, value2);
            map2.remove(m.getKey());
        }
        for (Map.Entry<Character, Integer> m : map2.entrySet()) {
            count += m.getValue();
        }
        return count;
    }
}
