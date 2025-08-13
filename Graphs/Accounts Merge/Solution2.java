import java.util.*;

class DSU {
    public int N;
    public int[] rank;
    public int[] parent;

    public DSU (int N){
        this.N = N;
        this.rank = new int[N];
        this.parent = new int[N];
        for(int i=0; i<N; i++){
            rank[i] = 0;
            parent[i] = i;
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
        int parentNodeOne = findParent(nodeOne);
        int parentNodeTwo = findParent(nodeTwo);
        if(parentNodeOne == parentNodeTwo){
            return false;
        }

        if(rank[parentNodeOne] == rank[parentNodeTwo]){
            rank[parentNodeOne] += 1;
            parent[parentNodeTwo] = parentNodeOne;
        } else if (rank[parentNodeOne] > rank[parentNodeTwo]){
            parent[parentNodeTwo] = parentNodeOne;
        } else {
            parent[parentNodeOne] = parentNodeTwo;
        }

        return true;
    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(accounts.size());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(map.containsKey(email)){
                    dsu.union(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> mergeMap = new HashMap<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String email = entry.getKey();
            int idx = dsu.findParent(entry.getValue());
            mergeMap.putIfAbsent(idx, new ArrayList<>());
            mergeMap.get(idx).add(email);           
        }

        List<List<String>> solList = new ArrayList<>();

        for(Map.Entry<Integer, List<String>> entry: mergeMap.entrySet()){
            int idx = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String accountName = accounts.get(idx).getFirst();
            emails.addFirst(accountName);
            solList.add(emails);
        }

        return solList;
    }
}