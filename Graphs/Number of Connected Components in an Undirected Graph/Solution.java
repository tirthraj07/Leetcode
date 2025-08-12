import java.util.*;

class Solution {
    public int countComponents(int n, int[][] edges) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		
		for(int i=0; i<n; i++){
			adjList.put(i, new ArrayList<>());
		}
				

		for(int[] edge : edges){
			int u = edge[0];
			int v = edge[1];
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		boolean[] visited = new boolean[n];
		int cnt = 0;

		for(int i=0; i<n; i++){
			if(!visited[i]){
				cnt++;
				visited[i] = true;
				dfs(i, visited, adjList);
			}
		}

		return cnt;
    }

	public void dfs(int node, boolean[] visited, Map<Integer, List<Integer>> adjList){
		for(int neighbour: adjList.get(node)){
			if(!visited[neighbour]){
				visited[neighbour] = true;
				dfs(neighbour, visited, adjList);
			}
		}
	}
}

