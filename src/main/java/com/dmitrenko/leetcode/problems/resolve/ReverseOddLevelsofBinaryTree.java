package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

public class ReverseOddLevelsofBinaryTree {

    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left, root.right, 0);
        return root;
    }

    private void reverse(TreeNode node1, TreeNode node2, int level) {
        if (node1 == null || node2 == null) return;

        if (level % 2 == 0) {
            var temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        reverse(node1.left, node2.right, level + 1);
        reverse(node1.right, node2.left, level + 1);
    }
}
