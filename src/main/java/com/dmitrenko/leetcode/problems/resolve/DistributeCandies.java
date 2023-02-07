package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashSet;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        var l = candyType.length / 2;
        var set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(set.size(), l);
    }
}
