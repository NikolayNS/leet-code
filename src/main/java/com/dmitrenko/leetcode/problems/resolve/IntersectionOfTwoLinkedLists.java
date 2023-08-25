package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.ListNode;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var set = new HashSet<ListNode>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
