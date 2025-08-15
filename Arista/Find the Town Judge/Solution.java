import java.util.*;
class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> inDegreeCnt = new HashMap<>();
        Map<Integer, Integer> outDegreeCnt = new HashMap<>();
        for(int i=1; i<=n; i++){
            inDegreeCnt.put(i, 0);
            outDegreeCnt.put(i, 0);
        }  

        for(int[] relation : trust){
            // u -> v => u trusts v
            int u = relation[0];
            int v = relation[1];
            outDegreeCnt.put(u, outDegreeCnt.get(u)  + 1);
            inDegreeCnt.put(v, inDegreeCnt.get(v) + 1);
        }

        for(int i=1; i<=n; i++){
            if(inDegreeCnt.get(i) == n-1 && outDegreeCnt.get(i) == 0){
                return i;
            }
        }

        return -1;
    }
}