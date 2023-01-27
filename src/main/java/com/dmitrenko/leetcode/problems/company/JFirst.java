package com.dmitrenko.leetcode.problems.company;

import java.util.LinkedList;
import java.util.List;

public class JFirst {

    public int[] foo(String[] strings) {
        var result = new int[strings.length];
        var l = strings.length;
        for (int i = 0; i < l; i++) {
            var common = 1;
            var cur = strings[i];
            var ls = strings[i].length();
            for (int j = 1; j < ls; j++) {
                if (cur.charAt(j - 1) == cur.charAt(j)) common++;
            }
            result[i] = common / 2;
        }

        return result;
    }

    public List<String> missingWords(String s, String t) {
        List<String> result = new LinkedList<>();

        String[] arr1 = s.split(" ");
        String[] arr2 = t.split(" ");

        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(j > arr2.length - 1 || !arr1[i].equals(arr2[j])){
                result.add(arr1[i]);
            }else {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new JFirst().missingWords("I am using HackerRank to improve programming", "am HackerRank to improve"));
    }
}
