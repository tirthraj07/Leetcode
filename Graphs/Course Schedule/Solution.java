import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Cycle Detection
// If cycle is present -> false, else true

class Solution {
    HashMap<Integer, ArrayList<Integer>> adjList;
    boolean[] visited;

    private boolean dfs(int node) {
        if (visited[node])
            return false;
        if (adjList.get(node).isEmpty())
            return true;

        visited[node] = true;
        for (int prerequisite : adjList.get(node)) {
            if (dfs(prerequisite) == false)
                return false;
        }

        adjList.put(node, new ArrayList<>());
        visited[node] = false;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.adjList = new HashMap<>();
        this.visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        // [a,b] ==> b is a pre-requisite to a
        // so 'a' can be completed if its prerequisites can also be completed
        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            adjList.get(a).add(b);
        }

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i) == false)
                return false;
        }
        return true;
    }
}

// Kahn's Algorithm
class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }

        // [ai, bi] ==> b1 -> a1
        for (int[] edge : prerequisites) {
            int ai = edge[0];
            int bi = edge[1];
            indegree[ai] += 1;
            adjList.get(bi).add(ai);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbour : adjList.get(node)) {
                indegree[neighbour] -= 1;
                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] > 0)
                return false;
        }
        return true;
    }
}