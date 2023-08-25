package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        var list = new ArrayList<Integer>();
        add(root, list);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            var c = list.get(i) - list.get(i - 1);
            if(c < min) min = c;
        }
        return min;
    }

    private void add(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        add(node.left, list);
        add(node.right, list);
    }
}
