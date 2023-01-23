package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;

public class NumberOfSegmentsInAString {

    public int countSegments(String s) {
        return Arrays.stream(s.split(" "))
            .filter(o -> !o.isEmpty())
            .toList()
            .size();
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSegmentsInAString().countSegments(""));
    }
}
