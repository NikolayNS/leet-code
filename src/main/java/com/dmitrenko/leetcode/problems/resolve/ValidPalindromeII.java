package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        return isPalindrome(s.toCharArray(), false);
    }

    private boolean isPalindrome(char[] chars, boolean flag) {
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                if (flag) {
                    return false;
                } else {
                    if (isPalindrome(Arrays.copyOfRange(chars, i + 1, chars.length - 1 - i), true) ||
                    isPalindrome(Arrays.copyOfRange(chars, i, chars.length - 2 - i), true)) return false;
                }
            }
        }
        return true;
    }
}
