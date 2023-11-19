//package com.globalcodingc.gcc.Service;
//
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//@Service
//public class Mlmm {
//
//
//        static int countSubsequenceUtil(int ind, int sum,
//                                        int []A, int N,
//                                        int [][]dp)
//        {
//
//            // Base condition
//            if (ind == N)
//                return 1;
//
//            // Return if the sub-problem
//            // is already calculated
//            if (dp[ind][sum] != -1)
//                return dp[ind][sum];
//
//            // Check if the current element is
//            // less than or equal to sum
//            if (A[ind] <= sum)
//            {
//
//                // Count subsequences excluding
//                // the current element
//                dp[ind][sum] = countSubsequenceUtil(
//                        ind + 1, sum,
//                        A, N, dp) +
//
//                        // Count subsequences
//                        // including the current
//                        // element
//                        countSubsequenceUtil(
//                                ind + 1,
//                                sum - A[ind],
//                                A, N, dp);
//            }
//            else
//            {
//
//                // Exclude current element
//                dp[ind][sum] = countSubsequenceUtil(
//                        ind + 1, sum,
//                        A, N, dp);
//            }
//
//            // Return the result
//            return dp[ind][sum];
//        }
//
//        // Function to return the count of subsequence
//// in an array with sum less than or equal to X
//        static int countSubsequence(int[] A, int N, int X)
//        {
//
//            // Initialize a DP array
//            int [][]dp = new int[N][X + 1];
//            for(int i = 0; i < N; i++)
//            {
//                for(int j = 0; j < X + 1; j++)
//                {
//                    dp[i][j] = -1;
//                }
//            }
//
//            // Return the result
//            return countSubsequenceUtil(0, X, A,
//                    N, dp) - 1;
//        }
//
//
//
//    public static List<Integer> findCombination(String payload) {
//        Queue<Integer> queue = new LinkedList<>();
//        List<Integer> answer = new ArrayList<>();
//        String[] data = payload.replaceAll("\\[", "")
//                .replaceAll("\\]", "")
//                .replaceAll(",", "")
//                .replaceAll(" ", ",")
//                .split(",");
//        List<Integer> a=new ArrayList<>();
////        for (int i = 0; i < data.length; i++) {
////            System.out.println(data[i]);
////        }
//
//        for (int i = 0; i < data.length; i++) {
//            queue.add(Integer.valueOf(data[i]));
//        }
//
//        while (!queue.isEmpty()) {
//
//            int maxSum = queue.remove();
//            int m = queue.remove();
//            int size=m;
//            List<Integer> b=new ArrayList<>();
//            for(int i=0;i<m;i++){
//                b.add(queue.remove());
//            }
//
//            List<Integer> c= new ArrayList<>(new HashSet<>(b));
//            System.out.println(b.size() + " "+ c.size());
//            int[] k=new int[b.size()];
//
//            for(int i=0;i<m;i++){
//                k[i]=c.get(i);
//            }
////            answer.add(countSubsequence(k,k.length,maxSum));
//        }
//
//        return answer;
//
//    }
//
//}
