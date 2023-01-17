package com.dmitrenko.leetcode.problems.resolve;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            result = Math.max(result, (price - min));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,6,4,3,1}));
    }
}
