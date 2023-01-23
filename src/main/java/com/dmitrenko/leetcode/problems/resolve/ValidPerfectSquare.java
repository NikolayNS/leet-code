package com.dmitrenko.leetcode.problems.resolve;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num > 0) {
            num = num - i;
            i = i + 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(49));
    }
}
