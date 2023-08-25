package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.Map;

public class DesignHashSet {

    private Map<Integer, Object> map;
    private final Object object = new Object();

    public DesignHashSet() {
        map = new HashMap<>();
    }

    public void add(int key) {
        map.put(key, object);
    }

    public void remove(int key) {
        map.remove(key);
    }

    public boolean contains(int key) {
        return map.containsKey(key);
    }
}
