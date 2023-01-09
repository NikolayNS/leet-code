package com.dmitrenko.leetcode.problems.resolve;

import com.dmitrenko.leetcode.util.ListNode;

import java.util.Collections;
import java.util.LinkedList;

public class MergeSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        var temp = new LinkedList<Integer>();

        for (ListNode list : lists) {
            var current = list;

            while (current != null) {
                temp.add(current.val);
                current = current.next;
            }
        }

        if (temp.isEmpty()) return null;
        Collections.sort(temp);

        var result = new ListNode();
        var current = result;

        for (int j = 0; j < temp.size(); j++) {
            Integer i = temp.get(j);
            current.val = i;
            if (j == temp.size() - 1) break;
            current.next = new ListNode();
            current = current.next;
        }

        return result;
    }
}
