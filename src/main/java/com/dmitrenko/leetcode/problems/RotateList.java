package com.dmitrenko.leetcode.problems;

import com.dmitrenko.leetcode.util.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (k==0 || head==null) return head;
        var cur = head;
        var prev = head;
        for (int i = 0; i < k; i++) {
            while (cur.next != null) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
            cur.next = head;
        }
        return cur;
    }

    public int solution(int[] A) {
        int n = A.length;
        Arrays.sort(A);

        var map = new HashMap<Integer, Integer>();
        for (int i = 1; i < n; i++) {
            map.merge(A[i] - A[i - 1], 1, Integer::sum);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (max < m.getValue()) {
                max = m.getValue();
            }
        }

        return max;
    }
}
