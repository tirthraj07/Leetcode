// For optimization, treat the int[][] as the adj matrix

import java.util.Stack;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                count += 1;
                st.add(i);
                visited[i] = true;
                while(!st.isEmpty()){
                    int curr = st.pop();
                    for(int j=0; j<isConnected[curr].length; j++){
                        if(isConnected[curr][j] == 1 && visited[j] == false){
                            visited[j] = true;
                            st.push(j);
                        }
                    }
                }
            }
        }

        return count;
    }
}