package com.dmitrenko.leetcode.problems.resolve;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        var result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result *= 26;
            result += columnTitle.charAt(i) - 64;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
    }
}
