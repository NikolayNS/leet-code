package com.dmitrenko.leetcode.problems.unresolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        var list = new ArrayList<Integer>();
        check(root, list, 0);
        System.out.println(list);
        return list
            .stream()
            .min(Integer::compare)
            .orElse(0);
    }

    private void check(TreeNode node, List<Integer> list, int prev) {
        if(node == null) return;
        list.add(Math.max(node.val, prev) - Math.min(node.val, prev));
        check(node.left, list, node.val);
        check(node.right, list, node.val);
    }
}
