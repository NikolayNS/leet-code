package com.dmitrenko.leetcode.problems.unresolve;

import java.util.ArrayList;
import java.util.Collections;

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        var k = 2;
        int max = 0;
        int count = 0;
        var list = new ArrayList<Integer>();
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                max = max + prices[i] - prices[i - 1];
                list.add(max);
            } else {
                max = 0;
                count++;
            }
        }
        Collections.sort(list);
        System.out.println(list);
        if(list.isEmpty()) return 0;
        var result = 0;
        int l = Math.min(count == 0 ? 1 : count, k);
        for (int i = 1; i <= l; i++) {
            result += list.get(list.size() - i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
