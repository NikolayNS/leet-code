package com.dmitrenko.leetcode.problems.resolve;

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        var arr = new int[]{0, 0};
        for (int i = 0; i < moves.length(); i++) {
            var c = moves.charAt(i);
            switch (c) {
                case 'U' -> arr[1] = arr[1] + 1;
                case 'D' -> arr[1] = arr[1] - 1;
                case 'R' -> arr[0] = arr[0] + 1;
                case 'L' -> arr[0] = arr[0] - 1;
                default -> throw new RuntimeException("Unknown char");
            }
        }
        return arr[0] == 0 && arr[1] == 0;
    }
}
