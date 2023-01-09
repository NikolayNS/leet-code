package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.ListNode;

import java.util.ArrayList;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        var temp = new ArrayList<ListNode>();

        var current = head;
        while (current != null) {
            temp.add(current);
            current = current.next;
        }

        if (temp.size() == n) return head.next;

        var c = temp.get(temp.size() - n - 1);
        c.next = n == 1 ? null : temp.get(temp.size() - n + 1);

        return head;
    }

    public static void main(String[] args) {
        //var current = new RemoveNthNodeFromEndOfList().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 1);
        var current = new RemoveNthNodeFromEndOfList().removeNthFromEnd(new ListNode(1, new ListNode(2)), 1);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
