package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class FairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        var aSum = Arrays.stream(aliceSizes).sum();
        var bSum = Arrays.stream(bobSizes).sum();
        var dif = (aSum - bSum) / 2;

        for (int i = 0; i < aliceSizes.length; i++) {
            for (int j = 0; j < bobSizes.length; j++) {
                if(aliceSizes[i] - bobSizes[j] == dif) return new int[]{aliceSizes[i], bobSizes[j]};
            }
        }
        return null;
    }
}
