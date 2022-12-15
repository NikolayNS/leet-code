package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        var max = 1;
        var chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            var set = new HashSet<Character>();
            set.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (set.contains(chars[j])) {
                    break;
                } else {
                    set.add(chars[j]);
                    max = Math.max(max, set.size());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
    }
}
