package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        var list = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            var c = i;
            boolean flag = true;
            while (c != 0) {
                var p = c % 10;
                if (p == 0 || i % p != 0) flag = false;
                c = c / 10;
            }
            if (flag) list.add(i);
        }

        return list;
    }
}
