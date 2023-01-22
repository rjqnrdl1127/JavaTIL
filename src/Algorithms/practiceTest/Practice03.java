package Algorithms.practiceTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice03 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()); // 123
        String s = String.valueOf(n); // "123"
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        System.out.println(result);
    }
}
