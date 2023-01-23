package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        var charsS = s.toCharArray();
        Arrays.sort(charsS);
        var charsT = t.toCharArray();
        Arrays.sort(charsT);

        for (int i = 0; i < charsS.length; i++) {
            if(charsT[i] != charsS[i]) return charsT[i];
        }

        return charsT[charsT.length - 1];
    }
}
