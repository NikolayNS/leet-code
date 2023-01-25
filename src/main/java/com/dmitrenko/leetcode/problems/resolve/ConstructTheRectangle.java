package com.dmitrenko.leetcode.problems.resolve;

public class ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        int mid = (int) Math.sqrt(area);

        while (mid != 1) {
            if (area % mid == 0) return new int[]{area / mid, mid};
            mid--;
        }

        return new int[]{area, 1};
    }
}
