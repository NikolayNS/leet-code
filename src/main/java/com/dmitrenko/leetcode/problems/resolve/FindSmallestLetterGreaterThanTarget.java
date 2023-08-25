package com.dmitrenko.leetcode.problems.resolve;

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (target < letter) return letter;
        }
        return letters[0];
    }
}
