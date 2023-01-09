package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();

        getLevel(result, 0, root);

        return result;
    }

    private void getLevel(List<List<Integer>> result, int level, TreeNode current) {
        if(current == null) return;

        if (result.size() == level) {
            result.add(new LinkedList<>());
        }

        var arr = result.get(level);
        arr.add(current.val);

        getLevel(result, level + 1, current.left);
        getLevel(result, level + 1, current.right);
    }


    public static void main(String[] args) {
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(new TreeNode(1, new TreeNode(3), new TreeNode(4))));
    }
}
