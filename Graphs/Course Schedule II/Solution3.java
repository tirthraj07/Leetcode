import java.util.*;

class Solution {
    // Topological Sort DFS
    public int[] findOrder(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegrees = new int[n];
        
        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            // edge[u,v] => v -> u
            adjList.get(v).add(u);
            inDegrees[u] += 1;
        }

        Stack<Integer> q = new Stack<>();

        for(int i=0; i<n; i++){
            if(inDegrees[i] == 0){  
                q.add(i);
            }
        }

        int[] order = new int[n];
        int idx = 0;

        while(!q.isEmpty()){
            int node = q.pop();
            order[idx++] = node;
            for(int neighbour: adjList.get(node)){
                inDegrees[neighbour] -= 1;
                if(inDegrees[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }

        return idx==n ? order : new int[0];
    }
}