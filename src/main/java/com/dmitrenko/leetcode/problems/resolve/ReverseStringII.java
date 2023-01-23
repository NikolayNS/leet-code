package com.dmitrenko.leetcode.problems.resolve;

public class ReverseStringII {

    public String reverseStr(String s, int k) {
        var builder = new StringBuilder();

        for (int i = k; i < s.length(); i = i + k * 2) {
            for (int j = i; j >= i - k; j--) {
                builder.append(s.charAt(j));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStringII().reverseStr("ababababb", 2));

    }
}
