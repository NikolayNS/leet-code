package com.dmitrenko.leetcode.problems.resolve;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        var l = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(l)) {
                if (l == s.length() - 1) return true;
                l++;
            }
        }

        return false;
    }
}
