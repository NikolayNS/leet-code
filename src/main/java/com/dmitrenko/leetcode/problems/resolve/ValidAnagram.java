package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        var charsS = s.toCharArray();
        var charsT = t.toCharArray();

        Arrays.sort(charsS);
        Arrays.sort(charsT);

        for (int i = 0; i < charsS.length; i++) {
            if(charsS[i] != charsT[i]) return false;
        }

        return true;
    }
}
