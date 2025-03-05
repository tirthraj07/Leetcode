import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {

    // A tree is an fully conntected undirected acyclic graph
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        if (n == 1)
            return true;

        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            adjList.putIfAbsent(a, new ArrayList<>());
            adjList.putIfAbsent(b, new ArrayList<>());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int visitedCount = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList.get(node)) {
                if (visited[neighbor])
                    continue;
                visited[neighbor] = true;
                queue.offer(neighbor);
                visitedCount++;
            }
        }

        return visitedCount == n;
    }
}
