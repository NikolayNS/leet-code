package com.dmitrenko.leetcode.problems.resolve;

public class GoatLatin {

    public String toGoatLatin(String sentence) {
        var arr = sentence.split(" ");
        var main = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            var word = arr[i];
            var builder = new StringBuilder();
            builder.append(word);
            if (!isVowel(word.toLowerCase().charAt(0))) {
                builder.deleteCharAt(0);
                builder.append(word.charAt(0));
            }
            builder.append("ma");
            builder.append("a".repeat(i + 1));
            main.append(builder);
            main.append(" ");
        }
        main.deleteCharAt(main.length() - 1);
        return main.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
