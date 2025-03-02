import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@SuppressWarnings("all")
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] sol = new int[numCourses];
        int currentCount = 0;

        for (int i = 0; i < numCourses; i++) {
            indegree[i] = 0;
            adjList.put(i, new ArrayList<>());
        }

        // [a,b] ==> b --> a
        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];

            indegree[a] += 1;
            adjList.get(b).add(a);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            sol[currentCount] = node;
            currentCount += 1;

            for (int neighbour : adjList.get(node)) {
                indegree[neighbour] -= 1;
                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }

        }

        if (currentCount != numCourses)
            return new int[] {};

        return sol;
    }
}