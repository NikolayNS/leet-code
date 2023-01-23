package com.dmitrenko.leetcode.problems.resolve;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        var builder = new StringBuilder();
        var k = 0;

        var l1 = num1.length();
        var l2 = num2.length();

        for (int i = 0; i < Math.max(l1, l2); i++) {
            if (l1 > i && l2 > i) {
                var c = num1.charAt(l1 - 1 - i) - '0' + num2.charAt(l2 - 1 - i) - '0' + k;
                builder.append(c % 10);
                k = c / 10;
            } else if (l1 <= i) {
                var c = num2.charAt(l2 - 1 - i) - '0' + k;
                builder.append(c % 10);
                k = c / 10;
            } else {
                var c = num1.charAt(l1 - 1 - i) - '0' + k;
                builder.append(c % 10);
                k = c / 10;
            }
        }

        if (k != 0) {
            builder.append(k);
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("199", "20"));
    }
}
