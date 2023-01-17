package com.dmitrenko.leetcode.problems.resolve;

public class ReverseString {

    public void reverseString(char[] s) {
        int j = s.length - 1;
        for (int i = 0; i < j; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }
}
