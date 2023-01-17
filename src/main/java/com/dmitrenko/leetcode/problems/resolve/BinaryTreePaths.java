package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        var builder = new StringBuilder();
        var list = new LinkedList<String>();

        swap(root, list, builder);
        return list;
    }

    private void swap(TreeNode node, List<String> list, StringBuilder builder) {
        if (node == null) return;

        builder.append(node.val);

        if (node.left == null && node.right == null) {
            list.add(builder.toString());
        }

        builder.append("->");

        swap(node.left, list, new StringBuilder(builder));
        swap(node.right, list, new StringBuilder(builder));
    }
}
