class DSU {
    public int[] parent;
    public int[] rank;
    public DSU(int N){
        this.parent = new int[N];
        this.rank = new int[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    public boolean union(int nodeOne, int nodeTwo){
        nodeOne = findParent(nodeOne);
        nodeTwo = findParent(nodeTwo);

        if(nodeOne == nodeTwo){
            return false;
        }

        if(rank[nodeOne] == rank[nodeTwo]){
            rank[nodeOne] += 1;
            parent[nodeTwo] = nodeOne;
        } else if(rank[nodeOne] > rank[nodeTwo]){
            parent[nodeTwo] = nodeOne;
        } else {
            parent[nodeOne] = nodeTwo;
        }

        return true;
    }
}

class Solution {
    public int makeConnected(int N, int[][] connections) {
        DSU dsu = new DSU(N);

        int redundantConnections = 0;

        for(int[] edge: connections){
            int u = edge[0];
            int v = edge[1];
            if(!dsu.union(u,v)){
                redundantConnections += 1;
            }
        }

        int components = 0;
        for (int i = 0; i < N; i++) {
            if (dsu.findParent(i) == i) { // i is a root
                components++;
            }
        }

        return (components - 1 <= redundantConnections) ? components - 1 : -1;
    }
}