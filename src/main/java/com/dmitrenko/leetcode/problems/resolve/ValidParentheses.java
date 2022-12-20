package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if ((stack.size()!=0)&&stack.peek() == map.get(s.charAt(i)))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        return stack.size() == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("({{{{}}}))"));
    }
}
