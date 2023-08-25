package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        var list = new ArrayList<Integer>();
        add(root, list);
        Collections.sort(list);
        var result = new TreeNode();
        var current = result;
        for (int i = 0; i < list.size(); i++) {
            current.val = list.get(i);
            if (i != list.size() - 1) {
                current.right = new TreeNode();
                current = current.right;
            }
        }
        return result;
    }

    private void add(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        add(node.left, list);
        add(node.right, list);
    }
}
