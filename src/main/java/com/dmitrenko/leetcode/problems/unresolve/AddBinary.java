package com.dmitrenko.leetcode.problems.unresolve;

public class AddBinary {

    public String addBinary(String a, String b) {
        var len1 = a.length() - 1;
        var len2 = b.length() - 1;

        var result = new StringBuilder();



        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("0011", "0011"));
    }
}
