package com.globalcodingc.gcc.Service;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class Mlmm {


    static int countSubarray(int arr[],
                             int n, int k)
    {
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {

                // If sum is less than
                // k then update sum and
                // increment count
                if (sum + arr[j] < k) {
                    sum = arr[j] + sum;
                    count++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }




    public static List<Integer> findCombination(String payload) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        String[] data = payload.replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(",", "")
                .replaceAll(" ", ",")
                .split(",");
//        List<Integer> a=new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

        for (int i = 0; i < data.length; i++) {
            queue.add(Integer.valueOf(data[i]));
        }

        while (!queue.isEmpty()) {

            int maxSum = queue.remove();
            int m = queue.remove();
            int[] k=new int[m];

            for(int i=0;i<m;i++){
                k[i]= queue.remove();
            }
            List<Integer> a=new ArrayList<>();
            for(int i=0;i<m;i++){
                a.add(k[i]);
            }
            List<Integer> b= new ArrayList<>(new HashSet<>(a));
            System.out.println(a.size() + " "+ b.size());
            int[] c=new int[b.size()];
            for(int i=0;i<b.size();i++){
                c[i]=b.get(i);
            }
            answer.add(countSubarray(c,c.length,maxSum));
        }

        return answer;

    }

}
