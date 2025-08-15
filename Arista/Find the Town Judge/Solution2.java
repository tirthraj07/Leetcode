class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegreeCnt = new int[n+1];
        int[] outDegreeCnt = new int[n+1];

        for(int[] relation : trust){
            // u -> v => u trusts v
            int u = relation[0];
            int v = relation[1];
            outDegreeCnt[u] += 1;
            inDegreeCnt[v] += 1;
        }

        for(int i=1; i<=n; i++){
            if(inDegreeCnt[i] == n-1 && outDegreeCnt[i] == 0){
                return i;
            }
        }

        return -1;
    }
}