package com.globalcodingc.gcc.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileReorg {
    public int longestPalindrome(String s) {

        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c]++;

        int oddCount = -1;
        for (int v : count) {
            if (v % 2 != 0) oddCount++;
        }

        return (oddCount > 0) ? s.length() - oddCount : s.length();
    }


    public List<Integer> findpalindrome(String[] payload) {

        List<Integer> answer = new ArrayList<>();

        String[] input = payload[0].split(", ");

        for (int k = 0; k < input.length; k++) {
                answer.add(longestPalindrome(input[k]));
        }
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

        return answer;

    }
}
