package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MinimumIndexSumofTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        var min = Integer.MAX_VALUE;
        var map = new HashMap<Integer, List<String>>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    var k = i + j;
                    map.computeIfAbsent(k, o -> new LinkedList<>());
                    map.get(k).add(list1[i]);
                    min = Math.min(min, k);
                }
            }
        }
        var list3 = map.get(min);
        var result = new String[list3.size()];
        return list3.toArray(result);
    }

    public static void main(String[] args) {
        new MinimumIndexSumofTwoLists().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
    }
}
