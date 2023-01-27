package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.Arrays;

public class KeyboardRow {

    private String s1 = "qwertyuiop";
    private String s2 = "asdfghjkl";
    private String s3 = "zxcvbnm";

    public String[] findWords(String[] words) {
        var result = new ArrayList<String>();
        for (String w : words) {
            var l = w.length();
            if (l != 0) {
                var r = w.toLowerCase();
                var s = getLine(r.charAt(0) + "");
                var flag = true;
                for (int i = 0; i < l; i++) {
                    if (!s.contains(r.charAt(i) + "")) {
                        flag = false;
                        break;
                    }
                }
                if (flag) result.add(w);
            }
        }
        return result.toArray(new String[0]);
    }

    private String getLine(String c) {
        if (s1.contains(c)) {
            return s1;
        } else if (s2.contains(c)) {
            return s2;
        } else {
            return s3;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new KeyboardRow().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
