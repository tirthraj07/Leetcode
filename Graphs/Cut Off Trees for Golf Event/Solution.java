import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    
    private class Node implements Comparable<Node> {
        public int treeHeight;
        public int i;
        public int j;

        Node(int treeHeight, int i, int j){
            this.treeHeight = treeHeight;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Node other) {
            // Give priority to the tree with lowest height.
            return Integer.compare(this.treeHeight, other.treeHeight);
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if(forest.getFirst().getFirst() == 0){
            return -1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i=0; i<forest.size(); i++){
            for(int j=0; j<forest.getFirst().size(); j++){
                if(forest.get(i).get(j) > 1){
                    pq.add(new Node(forest.get(i).get(j), i, j));
                }
            }
        }

        Node currNode = new Node(0, 0, 0);
        int totalCost = 0;

        while(!pq.isEmpty()){
            Node targetNode = pq.poll();
            
            int travelCost = bfs(forest, currNode, targetNode);

            if(travelCost == -1){
                return -1;
            }

            totalCost += travelCost;
            currNode = targetNode;
        }
        
        return totalCost;
    }


    private int bfs(List<List<Integer>> forest, Node sourceNode, Node targetNode){
        int m = forest.size();
        int n = forest.getFirst().size();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        visited[sourceNode.i][sourceNode.j] = true;
        q.add(new int[]{sourceNode.i, sourceNode.j, 0});
        while(!q.isEmpty()){
            int[] currentCoords = q.poll();
            int currI = currentCoords[0];
            int currJ = currentCoords[1];
            int currCost = currentCoords[2];
            if(targetNode.i == currI && targetNode.j == currJ){
                return currCost;
            }

            for(int i=0; i<4; i++){
                int nextI = currI + dx[i];
                int nextJ = currJ + dy[i];
                if(nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n && forest.get(nextI).get(nextJ) != 0 && visited[nextI][nextJ] == false){
                    visited[nextI][nextJ] = true;
                    q.add(new int[]{nextI, nextJ, currCost + 1});
                }
            }
        }
        
        return -1;
    }
}