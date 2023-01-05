package com.dmitrenko.leetcode.problems.resolve;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int j = 0;
        boolean flag = false;

        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i > 0 ; i--) {
            if (chars[i] != ' ') {
                flag = true;
            }
            if (flag) {
                if (chars[i] == ' ') break;
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));
    }
}
