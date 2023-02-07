package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        var map = new HashMap<Integer, Pair>();
        add(root, map, 0);
        return map.values()
            .stream()
            .map(o -> (double) o.vals / o.counts)
            .toList();
    }

    private void add(TreeNode node, Map<Integer, Pair> map, int level) {
        if(node == null) return;
        map.computeIfAbsent(level, o -> new Pair());
        var pair = map.get(level);
        pair.vals += node.val;
        pair.counts++;
        level++;
        add(node.left, map, level);
        add(node.right, map, level);
    }

    private static class Pair {
        private long vals;
        private long counts;

        private Pair() {
        }
    }
}
