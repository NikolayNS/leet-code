package com.dmitrenko.leetcode.problems.resolve;

public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        var a = 0;
        var l = 0;
        var flag = true;
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if ('A' == c) {
                a++;
                l = 0;
            } else if ('L' == c) {
                l++;
                if(l == 3) flag = false;
            } else {
                l = 0;
            }
        }
        return flag && a < 2;
    }
}
