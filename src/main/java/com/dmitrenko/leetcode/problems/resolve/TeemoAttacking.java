package com.dmitrenko.leetcode.problems.resolve;

public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        var result = 0;

        for (int i = 1; i < timeSeries.length; i++) {
            result += timeSeries[i - 1] + duration > timeSeries[i] ? (timeSeries[i] - timeSeries[i - 1]) : duration;
        }

        return result + duration;
    }

    public static void main(String[] args) {
        System.out.println(new TeemoAttacking().findPoisonedDuration(new int[]{1,3,4,5}, 5));
    }
}
