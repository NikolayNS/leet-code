package com.dmitrenko.leetcode.problems.resolve;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        var m = 1;
        var c = n;

        while (m <= c) {
            var middle = m + (c - m) / 2;
            if (!isBadVersion(middle)) {
                m = middle + 1;
            } else {
                c = middle - 1;
            }
        }

        return c;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
