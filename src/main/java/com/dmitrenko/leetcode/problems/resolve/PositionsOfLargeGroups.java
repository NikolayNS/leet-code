package com.dmitrenko.leetcode.problems.resolve;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans=new ArrayList<>();
        int start=0,n=s.length();
        for(int i=1;i<=n;i++){
            if((i==n) || !(s.charAt(i)==s.charAt(i-1))){
                if((i-start >=3)) ans.add(List.of(start,(i-1)));
                start=i;
            }
        }
        return ans;
    }
}
