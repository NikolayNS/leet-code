package com.dmitrenko.leetcode.problems.resolve;

public class Sqrt {

    public int mySqrt(int x) {
        var left = 1;
        var right = x;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (x / middle == middle) {
                return middle;
            } else if (x / middle < middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }
}
