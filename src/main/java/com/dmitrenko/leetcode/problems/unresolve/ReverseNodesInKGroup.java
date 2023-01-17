package com.dmitrenko.leetcode.problems.unresolve;

import com.dmitrenko.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        var temp = new ArrayList<ListNode>();

        var current = head;
        while (current != null) {
            temp.add(current);
            current = current.next;
        }

        return reverse(temp, k, 0);
    }

    private ListNode reverse(List<ListNode> temp, int k, int n) {
        if (temp.size() <= k + n) {
            return temp.get(n);
        }

        for (int i = n - 1 + k; i > n; i--) {
            var kNode = temp.get(i);
            kNode.next = temp.get(i - 1);
        }

        var c = temp.get(n);
        c.next = reverse(temp, k, k + n);

        return temp.get(k - 1);
    }

    public static void main(String[] args) {
        var current = new ReverseNodesInKGroup().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        //var current = new RemoveNthNodeFromEndOfList().removeNthFromEnd(new ListNode(1, new ListNode(2)), 1);
        //System.out.println(current.val);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
