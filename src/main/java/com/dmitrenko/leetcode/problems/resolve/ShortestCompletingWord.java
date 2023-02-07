package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        var map = new HashMap<Character, Integer>();
        var list = new ArrayList<String>();
        var temp = new ArrayList<Character>();
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                temp.add(c);
            }
        }
        for (String w : words) {
            boolean flag = true;
            for (char c : w.toCharArray()) {
                if (Character.isLetter(c)) map.merge(c, 1, Integer::sum);
            }
            for (char c : temp) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0) map.remove(c);
                } else {
                    flag = false;
                    break;
                }
            }
            System.out.println(map);
            if(flag) list.add(w);
            map.clear();
        }
        var min = Integer.MAX_VALUE;
        var i = 0;
        for (int j = 0; j < list.size(); j++) {
            if (min > list.get(j).length()) {
                min = list.get(j).length();
                i = j;
            }
        }
        return list.get(i);
    }

    public static void main(String[] args) {
        System.out.println(new ShortestCompletingWord().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }
}
