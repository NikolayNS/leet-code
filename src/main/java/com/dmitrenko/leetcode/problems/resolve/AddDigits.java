package com.dmitrenko.leetcode.problems.resolve;

public class AddDigits {

    public int addDigits(int num) {
        if (num < 10) return num;
        int result = 0;

        while (num != 0) {
            result = result + num % 10;
            num = num / 10;
        }

        return addDigits(result);
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));

    }
}
