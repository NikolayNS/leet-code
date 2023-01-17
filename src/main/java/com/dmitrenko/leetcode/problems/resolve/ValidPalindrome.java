package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        var chars = s.toLowerCase().toCharArray();
        var temp = new ArrayList<>();

        for (Character c : chars) {
            if (Character.isLetter(c) || Character.isDigit(c)) temp.add(c);
        }

        for (int i = 0; i < temp.size() / 2; i++) {
            if (temp.get(i) != temp.get(temp.size() - 1 - i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
    }
}
