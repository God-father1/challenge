package com.globalcodingc.gcc.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class EncryptingPP {
    String transposeMatrix(String str) {
        int strSize = str.length();
        int size = (int) Math.sqrt(strSize);
        int row, col;

        if (size * size == strSize) {
            row = size;
            col = size;
        } else if ((size + 1) * size <= strSize) {
            int matr=(size + 1) * size;
            if(matr<strSize){
                row=size+1;
                col=size+1;
            }
            else{
                row = size ;
                col = size+1;
            }

        } else {
            row = size + 1;
            col = size + 1;
        }
        System.out.println(row + " "+ col);
        char[][] matrix = new char[row][col];
        int k = 0;

        // Fill the matrix with characters from the input string
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (k <strSize) {
                    matrix[i][j] = str.charAt(k++);
                } else {
                    matrix[i][j] = '.';
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println(" ");
        }

        StringBuilder transposed = new StringBuilder();

        // Transpose the matrix and construct the transposed string
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if(matrix[j][i]!='.') {
                    transposed.append(matrix[j][i]);
                }
            }
            if(i+1!=col)
            transposed.append(" ");
        }

        return transposed.toString();
    }


    public List<String> findpalindrome(String payload) {

        List<String> answer = new ArrayList<>();

        String[] input = payload.replaceAll("\\[","")
                .replaceAll("]","")
                .replaceAll(" ","")
                .split(",");
        for (int k = 0; k < input.length; k++) {
            answer.add(transposeMatrix(input[k]));
        }
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

        return answer;

    }
}
