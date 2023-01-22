package Algorithms.Baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_24416 {

    public static int fibonachi(int n) {
        int[] fibos = new int[n + 1];
        fibos[1] = fibos[2] = 1;

        for (int i = 3; i <= n; i++) {
            fibos[i] = fibos[i - 1] + fibos[i - 2];
        }
        return fibos[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(fibonachi(n) + " " + (n - 2));
    }
}
