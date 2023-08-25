package com.dmitrenko.leetcode.problems.company;

import java.util.HashMap;

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        var map = new HashMap<Character, Integer>();
        for (char c : stones.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int result = 0;
        for (int i = 0; i < jewels.length(); i++) {
            var c = jewels.charAt(i);
            if (map.containsKey(c)) {
                result += map.get(c);
                map.remove(c);
            }
        }
        return result;
    }
}
