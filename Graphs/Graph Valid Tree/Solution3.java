import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // Detect A cycle in Undirected Graph using DFS
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        
        // If DFS finds a cycle
        if (hasCycle(0, -1, adjList, visited)) {
            return false;
        }

        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private boolean hasCycle(int node, int parent, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, adjList, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

}
