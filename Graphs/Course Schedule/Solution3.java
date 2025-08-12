import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    // Detect A cycle in a Directed Graph using BFS - Kahn's algorithm
    public boolean canFinish(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] indegreeCnt = new int[n];
		for(int i=0; i<n; i++){
			adjList.put(i, new ArrayList<>());
		}	

		for(int[] edge : edges){
			int u = edge[0];
			int v = edge[1];
			// here: edge [u,v] => v -> u
			adjList.get(v).add(u);
			indegreeCnt[u] += 1;
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<n; i++){
			if(indegreeCnt[i] == 0){
				q.offer(i);
			}
		}

		int topoCnt = 0;
		while(!q.isEmpty()){
			int v = q.poll();
			topoCnt += 1;
			for(int u: adjList.get(v)){
				indegreeCnt[u] -= 1;
				if(indegreeCnt[u] == 0){
					q.offer(u);
				}
			}
		}

		return topoCnt == n;
    }
}