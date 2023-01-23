package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();

        for (int i = 0; i < magazine.length(); i++) {
            if (i < ransomNote.length()) {
                map1.merge(ransomNote.charAt(i), 1, Integer::sum);
                map2.merge(magazine.charAt(i), 1, Integer::sum);
            } else {
                map2.merge(magazine.charAt(i), 1, Integer::sum);
            }
        }

        for (Map.Entry<Character, Integer> m : map1.entrySet()) {
            var s = map2.get(m.getKey());
            if(s == null || m.getValue() > s) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}
