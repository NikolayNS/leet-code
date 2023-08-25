package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){
        var result = new ArrayList<List<String>>();
        var map = new HashMap<String, List<String>>();
        for (String s : strs) {
            var chars = s.toCharArray();
            Arrays.sort(chars);
            var a = new String(chars);
            if(!map.containsKey(a)) map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add(s);
        }
        result.addAll(map.values());
        return result;
    }
}
