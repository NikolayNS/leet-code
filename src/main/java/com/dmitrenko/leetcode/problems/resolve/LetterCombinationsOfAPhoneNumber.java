package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    private static final Map<Character, List<Character>> MAP;

    static {
        MAP = new HashMap<>();
        MAP.put('2', List.of('a', 'b', 'c'));
        MAP.put('3', List.of('d', 'e', 'f'));
        MAP.put('4', List.of('g', 'h', 'i'));
        MAP.put('5', List.of('j', 'k', 'l'));
        MAP.put('6', List.of('m', 'n', 'o'));
        MAP.put('7', List.of('p', 'q', 'r', 's'));
        MAP.put('8', List.of('t', 'u', 'v'));
        MAP.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        if (digits.isEmpty()) return result;

        track(0, new StringBuilder(), digits, result);

        return result;
    }

    private void track(int i, StringBuilder str, String digits, List<String> result) {
        if (i == digits.length()) {
            result.add(str.toString());
            return;
        }

        for (Character aChar : MAP.get(digits.charAt(i))) {
            str.append(aChar);
            track(i + 1, str, digits, result);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }
}
