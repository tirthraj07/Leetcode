import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // Detect A cycle in a Directed Graph using DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            // edge [u, v] : v -> u. I.e you need to take course v before u
            int u = edge[0];
            int v = edge[1];
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[numCourses];   // fully processed
        boolean[] inStack = new boolean[numCourses];   // currently in recursion path

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(hasCycle(i, visited, inStack, adjList)){
                    return false;
                }
            }
        } 
        return true;
    }

    public boolean hasCycle(int node, boolean[] visited, boolean[] inStack, Map<Integer, List<Integer>> adjList){
        inStack[node] = true;

        for(int neighbor: adjList.get(node)){
            if (!visited[neighbor]) {
                if (inStack[neighbor]) {
                    return true; // cycle detected
                }
                if (hasCycle(neighbor, visited, inStack, adjList)) {
                    return true; // cycle found deeper
                }
            } else if (inStack[neighbor]) {
                return true; // back edge found
            }
        }

        inStack[node] = false;
        visited[node] = true;
        
        return false;
    }   

}