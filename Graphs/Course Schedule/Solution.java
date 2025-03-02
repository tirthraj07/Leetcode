import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
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