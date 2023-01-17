package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fist = head;
        ListNode second = head;

        while (fist != null && fist.next != null) {
            fist = fist.next.next;
            second = second.next;
            if (second.equals(fist)) {
                return true;
            }
        }
        return false;
    }
}
