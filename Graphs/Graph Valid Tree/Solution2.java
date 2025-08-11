// Detect A cycle in Undirected Graph using BFS

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Queue<int[]> q = new LinkedList<>(); // store [node, parent]
        boolean[] visited = new boolean[n];
        int visitedCount = 0;

        q.offer(new int[]{0, -1});

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];

            if (visited[node]) {
                return false; 
            }
            visited[node] = true;
            visitedCount++;

            for (int neighbor : adjList.get(node)) {
                // avoid going back to parent
                if (neighbor != parent) { 
                    q.offer(new int[]{neighbor, node});
                }
            }
        }

        // Must visit all nodes for the graph to be connected
        return visitedCount == n;

    }
}
