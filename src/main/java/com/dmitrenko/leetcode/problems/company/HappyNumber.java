package com.dmitrenko.leetcode.problems.company;

public class HappyNumber {

    public boolean isHappy(int n) {
        int temp = 0;
        while (n > 0) {
            temp = temp + (n % 10) * (n % 10);
            n = n / 10;
        }
        if (temp == 1) return true;
        if (temp == 4) return false;
        return isHappy(temp);
    }

    public static void main(String[] args) {
        new HappyNumber().isHappy(8);
    }
}
