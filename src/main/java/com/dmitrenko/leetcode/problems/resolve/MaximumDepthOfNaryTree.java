package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        if(root == null) return 0;
        var list = new ArrayList<Integer>();
        add(root, list, 1);
        Collections.sort(list);
        System.out.println(list);
        return list.get(list.size() - 1);
    }

    private void add(Node node, List<Integer> list, int level) {
        if (node.children == null || node.children.isEmpty()) {
            list.add(level);
            return;
        }
        node.children
            .forEach(o -> add(o, list, level + 1));
    }
}
