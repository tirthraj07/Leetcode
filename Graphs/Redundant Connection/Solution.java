import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@SuppressWarnings("all")
class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        // here edges[i] -> 1 indexed

        boolean[] visited = new boolean[edges.length];
        Map<Integer, Integer> parentofNode = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        parentofNode.put(1, -1);
        q.offer(1);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbour : edges[node - 1]) {
                if (visited[neighbour] && parentofNode.get(neighbour) == node)
                    continue;
                else if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    parentofNode.put(neighbour, node);
                    q.offer(neighbour);
                } else {
                    return new int[] { node, neighbour };
                }
            }

        }

        return new int[] { -1, -1 };

    }
}