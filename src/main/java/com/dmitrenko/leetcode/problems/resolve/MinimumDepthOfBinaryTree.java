package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        var list = new ArrayList<Integer>();
        add(root, 1, list);
        Collections.sort(list);
        return list.isEmpty() ? 0 : list.get(0);
    }

    private void add(TreeNode node, int level, List<Integer> list) {
        if(node == null) return;
        if(node.right == null && node.left == null) list.add(level);

        add(node.right, level + 1, list);
        add(node.left, level + 1, list);
    }
}
