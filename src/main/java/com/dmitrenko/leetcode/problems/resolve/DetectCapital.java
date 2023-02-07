package com.dmitrenko.leetcode.problems.resolve;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if (word.isEmpty()) return true;
        var count = 0;
        var l = word.length();
        for (int i = 0; i < l; i++) {
            if (Character.isUpperCase(word.charAt(i))) count++;
        }
        if (l == count) {
            return true;
        } else if (count == 0) {
            return true;
        } else if (count == 1) {
            return Character.isUpperCase(word.charAt(0));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new DetectCapital().detectCapitalUse("FlaG");
    }
}
