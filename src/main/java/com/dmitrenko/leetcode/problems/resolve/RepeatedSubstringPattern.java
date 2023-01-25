package com.dmitrenko.leetcode.problems.resolve;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        var p = s + s;
        return p.substring(1, s.length() - 1).contains(s);
    }
}
