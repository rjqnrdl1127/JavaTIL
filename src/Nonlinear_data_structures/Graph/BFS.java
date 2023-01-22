package Nonlinear_data_structures.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

    private static void bfs(int start, ArrayList<ArrayList<Integer>> list, int[] parents, int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        parents[start] = 1;

        while(!queue.isEmpty()) {
            int parent = queue.poll();

            for(int item : list.get(parent)) {
                if(parents[item] == 0) {
                    parents[item] = parent;
                    queue.offer(item);
                }

            }
        }
    }
}
