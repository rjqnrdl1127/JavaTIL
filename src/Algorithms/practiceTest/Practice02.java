package Algorithms.practiceTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice02 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        while(tokenizer.hasMoreTokens()) {
            int n = Integer.parseInt(tokenizer.nextToken());
            arr.add(n);
        }

        result.add(arr.get(0));
        for (int i = 1; i < arr.size() - 1; i++) {
            if (arr.get(i) != arr.get(i + 1)) {
                result.add(arr.get(i + 1));
            }
        }

        System.out.println(result);
    }
}
