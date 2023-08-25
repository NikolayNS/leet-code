package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        var numbers = new ArrayList<Integer>();
        var vowels = new ArrayList<Character>();

        var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                vowels.add(chars[i]);
                numbers.add(i);
            }
        }
        var j = 0;
        for (int i = vowels.size() - 1; i >= 0; i--) {
            chars[numbers.get(i)] = vowels.get(j);
            j++;
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("aA"));
    }
}
