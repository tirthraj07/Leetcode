class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] ^ arr[i];
        }
        
        int[] result = new int[queries.length];

        int idx = 0;
        for(int[] query: queries){
            int left = query[0];
            int right = query[1];
            if(left == 0){
                result[idx] = prefixSum[right];
            } else {
                result[idx] = prefixSum[right] ^ prefixSum[left - 1];
            }
            idx += 1;
        }

        return result;
    }
}