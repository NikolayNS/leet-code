package com.dmitrenko.leetcode.problems.resolve;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) return "0";
        if ("1".equals(num1)) return num2;
        if ("1".equals(num2)) return num1;

        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p = (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
                p += res[i + j + 1];
                res[i + j + 1] = p % 10;
                res[i + j] += p / 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int r : res) {
            if (builder.length() == 0 && r == 0) continue;
            builder.append(r);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("2925", "4787"));
    }
}
