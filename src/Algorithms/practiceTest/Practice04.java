package Algorithms.practiceTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 미완료
public class Practice04 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String move = reader.readLine();
        HashMap<int[], int[]> map = new HashMap<>();
        int[][] arr = new int[10][10];
        int count = 0, x = 5, y = 5;

        for (int i = 0; i < move.length(); i++) {
            char c = move.charAt(i);

            switch (c) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'R' -> x++;
                case 'L' -> x--;
            }

            if (x < 0) {
                x++;
            } else if (x > 9) {
                x--;
            } else if (y < 0) {
                y++;
            }else if (y > 9) {
                y--;
            } else {
                arr[x][y] = 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
