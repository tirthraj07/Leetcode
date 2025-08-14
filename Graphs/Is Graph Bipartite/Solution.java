import java.util.*;

class Solution {
    public boolean isBipartite(int[][] adjList) {
        int N = adjList.length;
        int[] colors = new int[N];
        Arrays.fill(colors, -1);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            if(colors[i] == -1){
                colors[i] = 0;
                q.offer(i);
                while(!q.isEmpty()){
                    int node = q.poll();
                    int nodeColor = colors[node];

                    for(int neighbour: adjList[node]){
                        if(colors[neighbour] == -1){
                            colors[neighbour] = (nodeColor == 0) ? 1 : 0;
                            q.add(neighbour);
                        } else if(colors[neighbour] == nodeColor){
                            return false;
                        }
                    }

                }


            }
        }

        return true;
    }
}