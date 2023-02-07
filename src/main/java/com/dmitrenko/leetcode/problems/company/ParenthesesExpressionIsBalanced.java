package com.dmitrenko.leetcode.problems.company;

public class ParenthesesExpressionIsBalanced {

    public boolean isBalanced(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = s.charAt(i) == '(' ? count + 1 : count - 1;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return original == reverse;
    }
}
