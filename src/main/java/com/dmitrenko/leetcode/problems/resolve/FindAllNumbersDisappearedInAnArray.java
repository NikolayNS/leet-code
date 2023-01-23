package com.dmitrenko.leetcode.problems.resolve;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        var list = new LinkedList<Integer>();
        var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i < nums.length; i++) {
            if (!set.contains(i)) list.add(i);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
