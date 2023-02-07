package com.dmitrenko.leetcode.problems.resolve;

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        var arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            var m = arr[i].toCharArray();
            var l = m.length;
            for (int j = 0; j < l / 2; j++) {
                var temp = m[l - 1 - j];
                m[l - 1 - j] = m[j];
                m[j] = temp;
            }
            arr[i] = new String(m);
        }
        var builder = new StringBuilder();
        for (String s1 : arr) {
            builder.append(s1);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
