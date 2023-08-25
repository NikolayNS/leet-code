package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        var arr = paragraph.split("[!?',;. ]");
        var map = new HashMap<String, Integer>();
        for (String a : arr) {
            map.merge(a.toLowerCase(), 1, Integer::sum);
        }
        for (String b : banned) {
            map.remove(b);
        }
        map.remove("");
        var a = "";
        var max = 0;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                a = m.getKey();
            }
        }
        return a;
    }

    public static void main(String[] args) {
        new MostCommonWord().mostCommonWord("Bob hit a ball, the,hit,BALL,flew far after it was hit.", new String[0]);
    }
}
