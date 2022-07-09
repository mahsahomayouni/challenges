package com.mahsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MaxSumOfHourGlass{



        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            List<List<Integer>> arr = new ArrayList<>();

            IntStream.range(0, 6).forEach(i -> {
                try {
                    arr.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            if (arr.size()<3)
                System.out.println("0");

            System.out.println(maxCountOfHourGlass(arr).toString());

        }
        private static Integer maxCountOfHourGlass(List<List<Integer>> arr){

            Integer max= Integer.MIN_VALUE;
            for (int i=0;i<arr.size()-2;i++){
                for (int j=0;j<arr.size()-2;j++){
                    Integer sum=arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i).get(j+2)+
                            arr.get(i+1).get(j+1)+
                            arr.get(i+2).get(j)+arr.get(i+2).get(j+1)+arr.get(i+2).get(j+2);
                    if (sum>max) max=sum;
                }
            }

            return max;

        }



}
