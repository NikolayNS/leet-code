package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return add(nums, 0, nums.length - 1);
    }

    private TreeNode add(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;

        TreeNode head = new TreeNode(nums[mid]);
        head.left = add(nums, l, mid - 1);
        head.right = add(nums, mid + 1, r);
        return head;
    }
}
