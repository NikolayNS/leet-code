package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.ListNode;

import java.util.ArrayList;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        var temp = new ArrayList<>();

        while (head != null) {
            temp.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < temp.size() / 2; i++) {
            if (temp.get(i) != temp.get(temp.size() - i - 1)) return false;
        }

        return true;
    }
}
