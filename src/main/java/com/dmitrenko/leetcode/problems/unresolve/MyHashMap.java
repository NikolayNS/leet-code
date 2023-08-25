package com.dmitrenko.leetcode.problems.unresolve;

import java.util.Arrays;

public class MyHashMap {

    private int[] arr;

    public MyHashMap() {
        arr = new int[16];
        Arrays.fill(arr, -1);
    }

    public void put(int key, int value) {
        if (arr.length < key) resize(key);
        arr[key - 1] = value;
    }

    private void resize(int key) {
        int[] newArr = new int[key];
        Arrays.fill(newArr, -1);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != -1) newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int get(int key) {
        return arr[key - 1];
    }

    public void remove(int key) {
        arr[key - 1] = -1;
    }
}
