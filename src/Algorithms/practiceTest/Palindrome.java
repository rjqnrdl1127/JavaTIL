package Algorithms.practiceTest;

import java.io.*;
import java.util.*;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int count = 0;
        String s;
        StringBuilder sb;

        for (int i = n; i <= m; i++) {
            s = String.valueOf(i);
            sb = new StringBuilder(s);

            if (s.equals(sb.reverse().toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
}