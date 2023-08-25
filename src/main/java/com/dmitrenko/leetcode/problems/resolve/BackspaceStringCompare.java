package com.dmitrenko.leetcode.problems.resolve;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return modify(s).equals(modify(t));
    }

    private String modify(String s) {
        var builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == '#' && builder.length() != 0) {
                builder.deleteCharAt(builder.length() - 1);
            } else if (Character.isLetter(c)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
