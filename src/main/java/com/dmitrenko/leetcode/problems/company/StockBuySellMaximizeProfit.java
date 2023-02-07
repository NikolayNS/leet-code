package com.dmitrenko.leetcode.problems.company;

import java.util.Arrays;

public class StockBuySellMaximizeProfit {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i - 1] < prices[i]) max = max + prices[i] - prices[i - 1];
        }
        return max;
    }

    public int minCoins(int[] coins, int sum) {
        int[] arr = new int[sum + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for (int i = 1; i <= sum; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    arr[i] = Math.min(arr[i], arr[i - coin] + 1);
                }
            }
        }
        return arr[sum];
    }
}
