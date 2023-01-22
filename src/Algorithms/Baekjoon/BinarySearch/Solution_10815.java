package Algorithms.Baekjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_10815 {

    private static int BinarySearch(int[] arr, int i) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (i == arr[mid]) {
                return 1;
            } else if (i < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int n = Integer.parseInt(reader.readLine());
        int[] card = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(card);

        int m = Integer.parseInt(reader.readLine());
        int[] card2 = new int[m];
        tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < m; i++) {
            card2[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i : card2) {
            System.out.print(BinarySearch(card, i) + " ");
        }
        reader.close();
    }
}
