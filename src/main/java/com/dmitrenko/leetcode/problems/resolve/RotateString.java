package com.dmitrenko.leetcode.problems.resolve;

public class RotateString {

    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        int point = 0;
        for (int i = 0; i < s.length(); i++) {
            if (goal.charAt(0) == s.charAt(i)) {
                break;
            } else {
                point = i;
            }
        }
        if(point == 0) point = 1;
        return (s.substring(point) + s.substring(0, point)).equals(goal);
    }

    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("gcmbf", "fgcmb"));
    }
}
