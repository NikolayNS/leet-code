package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;

public class BaseballGame {

    public int calPoints(String[] operations) {
        var list = new ArrayList<Integer>();
        for (String s : operations) {
            switch (s) {
                case "D" -> {if(!list.isEmpty()) list.add(list.get(list.size() - 1) * 2);}
                case "C" -> {if(!list.isEmpty()) list.remove(list.size() - 1);}
                case "+" -> {if(list.size() > 1) list.add(list.get(list.size() - 1) + list.get(list.size() - 2));}
                default -> list.add(Integer.valueOf(s));
            }
        }
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
