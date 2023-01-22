package Algorithms.Baekjoon.Stack;

import java.io.*;
import java.util.Stack;


public class Solution_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = reader.readLine();
        int M = Integer.parseInt(reader.readLine());

        Stack<String> leftSt = new Stack<>();
        Stack<String> rightSt = new Stack<>();

        String[] arr = str.split("");
        for (String s : arr) {
            leftSt.push(s);
        }

        for (int i = 0; i < M; i++) {
            String command = reader.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (!leftSt.isEmpty()) {
                        rightSt.push(leftSt.pop());
                    }
                    break;
                case 'D':
                    if (!rightSt.isEmpty()) {
                        leftSt.push(rightSt.pop());
                    }
                    break;
                case 'B':
                    if (!leftSt.isEmpty()) {
                        leftSt.pop();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    leftSt.push(String.valueOf(t));
                    break;
                default:
                    break;
            }
        }

        while (!leftSt.isEmpty()) {
            rightSt.push(leftSt.pop());
        }

        while(!rightSt.isEmpty()) {
            writer.write(rightSt.pop());
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
