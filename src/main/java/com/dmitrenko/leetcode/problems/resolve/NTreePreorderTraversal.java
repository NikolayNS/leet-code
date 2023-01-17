package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.Node;

import java.util.ArrayList;
import java.util.List;

public class NTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        var result = new ArrayList<Integer>();
        add(root, result);
        return result;
    }

    private void add(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        node.children.forEach(o -> add(o, list));
    }
}
