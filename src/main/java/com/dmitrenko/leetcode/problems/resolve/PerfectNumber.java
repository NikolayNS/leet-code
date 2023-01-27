package com.dmitrenko.leetcode.problems.resolve;

public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        var l = num / 2;
        var sum = 0;
        for (int i = 1; i <= l; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }
}
