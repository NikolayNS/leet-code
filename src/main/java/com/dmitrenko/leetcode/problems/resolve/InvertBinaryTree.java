package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        var left = invertTree(root.left);
        var right = invertTree(root.right);

        root.right=left;
        root.left = right;
        return root;
    }
}
