package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        var map = new HashMap<Character, Integer>();

        for (char p : s.toCharArray()) {
            map.merge(p, 1, Integer::sum);
        }

        var count = 0;
        var c = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() % 2 == 0) {
                count = count + m.getValue();
            } else {
                count = count + m.getValue() - 1;
                c = 1;
            }
        }

        return count + c;
    }
}
