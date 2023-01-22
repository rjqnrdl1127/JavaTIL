package Algorithms.Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_21313 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        boolean add = false;

        if (n % 2 == 1) {
            add = true;
            n--;
        }
        StringBuilder builder = new StringBuilder();
        while (n-- > 0) {
            if (n % 2 == 1) builder.append("1").append(" ");
            else builder.append("2").append(" ");
        }
        if (add) builder.append("3");

        System.out.println(builder.toString());
    }
}
