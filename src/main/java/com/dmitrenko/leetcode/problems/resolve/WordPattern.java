package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        var map = new HashMap<Character, String>();
        var map2 = new HashMap<String, Character>();

        var strings = s.split(" ");
        if (pattern.length() != strings.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            var p = map.get(pattern.charAt(i));
            if (p != null && !p.equals(strings[i])) {
                return false;
            } else {
                var d = map2.get(strings[i]);
                if (d != null && d != pattern.charAt(i)) {
                    return false;
                } else {
                    map2.put(strings[i], pattern.charAt(i));
                    map.put(pattern.charAt(i), strings[i]);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    }
}
