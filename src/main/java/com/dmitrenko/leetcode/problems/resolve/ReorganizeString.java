package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;

public class ReorganizeString {

    public String reorganizeString(String s) {
        var arr = new ArrayList<Character>();
        var builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            arr.add(s.charAt(i));
        }

        for (int i = 0; i < arr.size(); i++) {

            if (!arr.get(i).equals(arr.get(i + 1))) {
                builder.append(arr.get(i));
                builder.append(arr.get(i + 1));
                arr.remove(i + 1);
            } else {
                builder.append(arr.get(i));
                var c = ' ';
                for (int j = i + 1; j < arr.size(); j++) {
                    if (!arr.get(i).equals(arr.get(j))) {
                        c = arr.get(j);
                        arr.remove(arr.get(j));
                        break;
                    }
                }
                if (c == ' ') return "";
                builder.append(c);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aab"));
    }
}
