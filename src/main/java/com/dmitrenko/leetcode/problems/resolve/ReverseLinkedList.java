package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        var privios = head;
        var current = head;

        while (current != null) {
            var next = current.next;
            current.next = privios;
            privios = current;
            current = next;
        }
        return privios;
    }

    public static void main(String[] args) {

    }
}
