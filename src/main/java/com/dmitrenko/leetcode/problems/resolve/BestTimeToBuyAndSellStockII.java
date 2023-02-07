package com.dmitrenko.leetcode.problems.resolve;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i - 1] < prices[i]) max = max + prices[i] - prices[i - 1];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{100, 180, 260, 310, 40, 535, 695}));
    }
}
