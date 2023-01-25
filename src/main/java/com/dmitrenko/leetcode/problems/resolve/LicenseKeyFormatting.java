package com.dmitrenko.leetcode.problems.resolve;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        var builder = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c)) {
                if (count == k) {
                    builder.append('-');
                    count = 0;
                }
                builder.append(Character.toUpperCase(c));
                count++;
            }
        }
        return builder.reverse().toString();
    }
}
