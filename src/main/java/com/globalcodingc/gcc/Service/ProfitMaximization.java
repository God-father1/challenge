package com.globalcodingc.gcc.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class ProfitMaximization {


    static int findProfit(int numOfPredictedDays, int[] predictedSharePrices) {
        int max = predictedSharePrices[1] - predictedSharePrices[0];
        for (int i = 0; i < numOfPredictedDays; i++) {
            for (int j = i + 1; j < numOfPredictedDays; j++) {
                int temp = predictedSharePrices[j] - predictedSharePrices[i];
                if (temp > max)
                    max = temp;
            }
        }
        return max;
    }

    public List<Integer> findMaxProfit(String[] payload) {

        List<Integer> answer = new ArrayList<>();

        String[] input = payload[0].split(", ");

        for (int k = 0; k < input.length; k++) {

            String[] data = input[k].replaceAll("\\[", "")
                    .replaceAll("\\]", "")
                    .replaceAll(",", "")
                    .replaceAll(" ", ",")
                    .split(",");


            int size = data.length;
            int[] arr = new int[size - 1];
            int count = 0;
            int j = 0;
            for (int i = 0; i < data.length; i++) {
                if (i == 0) {
                    count = Integer.valueOf(data[i]);
                } else {
                    arr[j++] = Integer.valueOf(data[i]);
                }

            }
            if(count>size-1 && count==0){
                answer.add(0);
            }
            else {
                answer.add(findProfit(count, arr));
            }
        }
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

        return answer;

    }
}
