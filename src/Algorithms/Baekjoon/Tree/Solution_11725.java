package Algorithms.Baekjoon.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 부모 찾기
public class Solution_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean visit[] = new boolean[n + 1];
        List<Integer> list[] = new ArrayList[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        queue.add(1);
        visit[1] = true;
        int ans[] = new int[n + 1];
        while(!queue.isEmpty()) {
            Integer num = queue.poll();
            for (Integer i: list[num]) {
                if (!visit[i]) {
                    visit[i] = true;
                    ans[i] = num;
                    queue.add(i);
                }
            }
        }
        for (int i = 2; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
