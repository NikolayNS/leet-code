package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SecondMinimumNodeBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        var set = new HashSet<Integer>();
        add(root, set);
        var temp = set.toArray(new Integer[0]);
        Arrays.sort(temp);
        return temp.length >= 2 ? temp[1] : -1;
    }

    private void add(TreeNode node, Set<Integer> set) {
        if(node == null) return;
        set.add(node.val);
        add(node.left, set);
        add(node.right, set);
    }

    public static void main(String[] args) {
        new SecondMinimumNodeBinaryTree().findSecondMinimumValue(new TreeNode(2, new TreeNode(2), new TreeNode(2147483647)));
    }
}
