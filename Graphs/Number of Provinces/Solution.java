import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<isConnected.length; i++){
            adjList.putIfAbsent(i, new ArrayList<>());
            for(int j=0; j<isConnected[i].length; j++){
                adjList.putIfAbsent(j, new ArrayList<>());
                if(i!=j && isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                count += 1;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }   

    private void dfs(int start, Map<Integer, List<Integer>> adjList, boolean[] visited){
        Stack<Integer> st = new Stack<>();
        st.add(start);
        visited[start] = true;
        while(!st.isEmpty()){
            int curr = st.pop();
            for(int i=0; i<adjList.get(curr).size(); i++){
                if(visited[adjList.get(curr).get(i)] == false){
                    st.push(adjList.get(curr).get(i));
                    visited[adjList.get(curr).get(i)] = true;
                }
            }
        }
    }

}