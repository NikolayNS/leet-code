package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashSet;

public class UniqueMorseCodeWords {

    private static final String[] A = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        var set = new HashSet<String>();
        for (String w : words) {
            var builder = new StringBuilder();
            for (int i = 0; i < w.length(); i++) {
                builder.append(A[w.charAt(i) - 'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }
}
