package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();

        reverse(root, result);
        return result;
    }

    private void reverse(TreeNode node, List<Integer> result) {
        if (node == null) return;
        reverse(node.left, result);
        result.add(node.val);
        reverse(node.right, result);
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
    }
}
