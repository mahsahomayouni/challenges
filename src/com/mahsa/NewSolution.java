package com.mahsa;

import java.util.*;

public class NewSolution {
    public int solutiontwo(String[] E) {

        Integer[] listCount1=new Integer[]{0,0,0,0,0,0,0,0,0,0};
        Integer[] listCount2=new Integer[]{0,0,0,0,0,0,0,0,0,0};
        for (Integer i = 0; i < E.length; i++) {
            String s = E[i];
            int count = 0;
            for (int j = 0; j < 10; j++) {
                if (s.contains(String.valueOf(j)))
                    listCount1[j]+=1;
            }

        }
        List<Integer> l1=Arrays.asList(listCount1);
        int day1 = Collections.max(l1);
        int index1=l1.indexOf(day1);

        for (Integer i = 0; i < E.length; i++) {
            String s = E[i];
            int count = 0;
            for (int j = 0; j < 10; j++) {
                if (s.contains(String.valueOf(j))&&(!s.contains(String.valueOf(index1))))
                    listCount2[j]+=1;
            }

        }
        List<Integer> l2=Arrays.asList(listCount2);
        int day2 = Collections.max(l2);
        int index2=l2.indexOf(day2);

        return day1+day2;
        // write your code in Java SE 8
    }

//    private int repeatCount(String s, Integer x, Integer notContain) {
//        int count = 0;
//        if (s.length() == 0)
//            return 0;
//        if (!notContain.equals(null)) {
//            if s.contains()
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.getNumericValue(s.charAt(i)) == x)
//                count++;
//
//
//        }
//        return count;
//    }

    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
/////
            if (m == l)
                m += 1;
            /////
            if (A[m] > X) {
                r = m - 1;
                //
            } else {//if  ((A[m] == X)){
                l = m;
            }
//            else {
//            return m;
//            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}
//        int solution(int[] A, int X) {
//        int N = A.length;
//        if (N == 0) {
//        return -1;
//        }
//        int l = 0;
//        int r = N - 1;
//        while (l < r) {
//        int m = (l + r) / 2;
//        //
//        if (A[m] > X) {
//        r = m - 1;
//        } else {
//        l = m;
//        }
//        }
//        if (A[l] == X) {
//        return l;
//        }
//        return -1;
//        }
