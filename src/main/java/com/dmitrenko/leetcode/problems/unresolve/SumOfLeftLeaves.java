package com.dmitrenko.leetcode.problems.unresolve;

import com.dmitrenko.leetcode.util.TreeNode;

public class SumOfLeftLeaves {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        solve(root);
        return sum;
    }

    private void solve(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isLeaf(node.left)) {
            sum += node.left.val;
        }
        solve(node.left);
        solve(node.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }
}
