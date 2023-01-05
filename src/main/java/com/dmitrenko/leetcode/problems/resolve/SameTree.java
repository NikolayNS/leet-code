package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return  true;
        if (p == null || q == null || q.val != p.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(new SameTree().isSameTree(new TreeNode(1, new TreeNode(2), null), new TreeNode(1, new TreeNode(2), null)));
    }
}
