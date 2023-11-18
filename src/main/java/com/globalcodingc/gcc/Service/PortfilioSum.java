package com.globalcodingc.gcc.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class PortfilioSum {
    int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        int result = 0, s1Count = 0, st2Count = 0, totalSum = 0;
        for (Integer s1Element : a) {
            if (totalSum + s1Element > maxSum) break;
            totalSum += s1Element;
            s1Count++;

        }
        result = s1Count;
        for (Integer s2Element : b) {
            totalSum += s2Element;
            st2Count++;
            while (totalSum > maxSum && s1Count > 0) {
                totalSum -= a.get(s1Count - 1);
                s1Count--;
            }
            result = (totalSum <= maxSum) ? Math.max(s1Count + st2Count, result) : result;
        }
        return result;
    }

    public List<Integer> findMaxProfit(String payload) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        String[] data = payload.replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(",", "")
                .replaceAll(" ", ",")
                .split(",");

        for (int i = 0; i < data.length; i++) {
            queue.add(Integer.valueOf(data[i]));
        }

        while (!queue.isEmpty()) {

            int n = queue.remove();
            int m = queue.remove();
            int maxSum = queue.remove();
            List<Integer> a = new ArrayList<>(n);
            List<Integer> b = new ArrayList<>(m);
            while (n > 0) {
                a.add(queue.remove());
                n--;
            }
            while (m > 0) {
                b.add(queue.remove());
                m--;
            }
            answer.add(twoStacks(maxSum, a, b));
        }

        return answer;

    }
}
