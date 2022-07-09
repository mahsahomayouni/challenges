package com.mahsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s=="" || s==null)
            return 0;
        if (s.length()==1)
            return 1;
        String temp=String.valueOf(s.charAt(0));
        List<Integer> countList=new ArrayList<>();
        Integer count=1;
        for (int i=1; i<s.length();i++) {
            if (temp.contains(String.valueOf(s.charAt(i)))) {
                temp = String.valueOf(s.charAt(i));
                countList.add(count);
                count = 1;
            } else {
                temp = temp + s.charAt(i);
                count++;
            }
        }
        if (countList.size()>0)
        return Collections.max(countList);
        else
            return count;
    }

}
