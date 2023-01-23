package com.dmitrenko.leetcode.problems.resolve;

public class SumDigitsStringAfterConvert {

    public int getLucky(String s, int k) {
        var chars = s.toCharArray();
        var builder = new StringBuilder();

        for (char c : chars) {
            builder.append(c - 96);
        }

        return Integer.parseInt(trans(builder.toString(), k, 0));
    }

    private String trans(String num, int k, int level) {
        if (num.length() == 1 || k == level) return num;
        var result = 0L;

        var chars = num.toCharArray();
        for (char c : chars) {
            result = result + Integer.parseInt(c + "");
        }

        return trans(result + "", k, level + 1);
    }

    public static void main(String[] args) {
        System.out.println(new SumDigitsStringAfterConvert().getLucky("abc", 3));
    }
}
