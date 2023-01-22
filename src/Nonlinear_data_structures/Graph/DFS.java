package Nonlinear_data_structures.Graph;

import java.util.ArrayList;

public class DFS {

    private static void dfs(ArrayList<Integer>[] list, int[] parents, int n, int start, int parent) {
        // TODO Auto-generated method stub
        parents[start] = parent;
        for(int item : list[start]) {
            if(item != parent) dfs(list, parents, n, item, start);
        }
    }
}
