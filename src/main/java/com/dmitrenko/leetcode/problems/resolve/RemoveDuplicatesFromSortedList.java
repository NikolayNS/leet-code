package com.dmitrenko.leetcode.problems.resolve;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        var temp = head;
        var curr = head;

        while (curr != null) {
            if (temp.val != curr.val) {
                temp.next = curr;
                temp = temp.next;
            }
            curr = curr.next;
        }

        temp.next = null;

        return head;
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
        System.out.println(new RemoveDuplicatesFromSortedList().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))))));
    }
}
