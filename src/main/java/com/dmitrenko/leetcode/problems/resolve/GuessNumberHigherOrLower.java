package com.dmitrenko.leetcode.problems.resolve;

public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 0;
        int right = n;

        while (left <= right) {
            int num = left + (right - left) / 2;
            int cur = guess(num);
            if (cur == 0) {
                return num;
            } else if (cur == 1) {
                left = num + 1;
            } else {
                right = num - 1;
            }
        }

        return left;
    }

    int guess(int num) {
        return Integer.compare(2126753389, num);
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumberHigherOrLower().guessNumber(2126753390));
    }
}
