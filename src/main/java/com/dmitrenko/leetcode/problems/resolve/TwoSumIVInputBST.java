package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumIVInputBST {

    public boolean findTarget(TreeNode root, int k) {
        var list = new ArrayList<Integer>();
        add(root, list);
        Collections.sort(list);
        var i = 0;
        var l = list.size() - 1;
        while (i < l) {
            var c = list.get(i) + list.get(l);
            if (c == k) {
                return true;
            } else if (c < k) {
                i++;
            } else {
                l--;
            }
        }
        return false;
    }

    private void add(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        add(node.left, list);
        add(node.right, list);
    }
}
