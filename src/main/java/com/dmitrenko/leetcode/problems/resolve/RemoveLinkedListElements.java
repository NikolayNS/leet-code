package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        var dummy = head;
        var pre = dummy;
        while (pre.next != null) {
            if (pre.next.val != val)
                pre = pre.next;
            else
                pre.next = pre.next.next;
        }
        return dummy.next;
    }
}
