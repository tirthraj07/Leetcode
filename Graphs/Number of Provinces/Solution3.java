import java.util.*;
class DSU {
    public int N;
    public int[] parents;
    public int[] rank;
    public DSU(int N){
        this.N = N;
        this.parents = new int[N];
        this.rank = new int[N];
        for(int i=0; i<N; i++){
            parents[i] = i;
            rank[i] = 0;
        }
    }

    public int findParent(int node){
        if(parents[node] == node){
            return node;
        }

        parents[node] = findParent(parents[node]);
        return parents[node];
    }

    public boolean union(int nodeOne, int nodeTwo){
        nodeOne = findParent(nodeOne);
        nodeTwo = findParent(nodeTwo);
        if(nodeOne == nodeTwo){
            return false;
        }
        
        if(rank[nodeOne] == rank[nodeTwo]){
            rank[nodeOne] += 1;
            parents[nodeTwo] = nodeOne;
        } else if(rank[nodeOne] > rank[nodeTwo]){
            parents[nodeTwo] = nodeOne;
        } else {
            parents[nodeOne] = nodeTwo;
        }

        return true;
    }

}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        DSU dsu = new DSU(N);
        for(int i=0; i<N; i++){
            // Since isConnected is symmetric (i.e., if isConnected[i][j] == 1, then isConnected[j][i] == 1), you only need to loop for j > i to avoid redundant union calls:
            for(int j=i+1; j<N; j++){
                if(isConnected[i][j] == 1){
                    dsu.union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(dsu.findParent(i));
        }


        return set.size();
    }
}