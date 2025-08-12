class DSU {
    public int N;
    public int[] rank;
    public int[] parent;

    public DSU (int N){
        this.N = N;
        this.rank = new int[N+1];
        this.parent = new int[N+1];
        for(int i=0; i<N+1; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }

    // Returns the ultimate representative/parent of the node.
    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    // Returns true if node nodeOne and nodeTwo belong to different component and update the representatives/parent accordingly, otherwise returns false.
    public boolean doUnion(int nodeOne, int nodeTwo){
        int parentOfNodeOne = findParent(nodeOne);
        int parentOfNodeTwo = findParent(nodeTwo);
        
        if(parentOfNodeOne == parentOfNodeTwo){
            return false;
        }

        // Union by rank logic:
        if (rank[parentOfNodeOne] > rank[parentOfNodeTwo]) {
            // Attach the smaller tree under the bigger tree, no rank increment needed
            parent[parentOfNodeTwo] = parentOfNodeOne;
        } else if (rank[parentOfNodeOne] < rank[parentOfNodeTwo]) {
            parent[parentOfNodeOne] = parentOfNodeTwo;
        } else {
            // Same rank: attach and increase the rank of new root by 1
            parent[parentOfNodeTwo] = parentOfNodeOne;
            rank[parentOfNodeOne]++;
        }

        return true;
    }

}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // The number of edges in an connected undirected acyclic graph = n-1 : Where n is number of nodes
        // In this problem, only one edge makes the graph cyclic.
        // There for the number of edges given = (n-1)+1 = n
        
        int N = edges.length;
        DSU dsu = new DSU(N);   

        int[] redundantEdge = new int[]{-1, -1};
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(!dsu.doUnion(u, v)){
                redundantEdge[0] = u;
                redundantEdge[1] = v;
                return redundantEdge;
            }
        }

        return redundantEdge;
    }
}