package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        var map = new TreeMap<Integer, Integer>();

        while (head != null) {
            map.merge(head.val, 1, Integer::sum);
            head = head.next;
        }

        ListNode first = null;
        ListNode prev = null;
        ListNode curr = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                curr = new ListNode(entry.getKey());

                if (first == null) first = curr;

                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
            }
        }

        return first;
    }
    private static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(new ListNode(1, new ListNode(-1, new ListNode(-2, new ListNode(3, new ListNode(3, new ListNode(5, null))))))));
    }
}
