package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();

        add(root, result);
        Collections.reverse(result);

        return result;
    }

    private void add(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        add(node.left, result);
        add(node.right, result);
    }
}
