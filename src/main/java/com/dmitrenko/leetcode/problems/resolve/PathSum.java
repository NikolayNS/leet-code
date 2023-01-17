package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return sum(root, targetSum, 0);
    }

    public boolean sum(TreeNode node, int targetSum, int prev) {
        if (node == null) return false;
        var sum = node.val + prev;

        if (sum == targetSum && (node.right == null || node.left == null)) return true;

        return sum(node.left, targetSum, sum) || sum(node.right, targetSum, sum);
    }
}
