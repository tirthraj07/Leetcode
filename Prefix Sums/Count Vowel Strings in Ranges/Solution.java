class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n];
        for(int i=0; i<n; i++){
            String word = words[i];
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            if(isVowel(first) && isVowel(last)){
                prefixSum[i] = (i == 0) ? 1 : prefixSum[i-1] + 1;
            } else {
                prefixSum[i] = (i == 0) ? 0 : prefixSum[i-1];
            }
        }

        int[] result = new int[queries.length];

        for(int i = 0; i<queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];

            if(left == 0){
                result[i] = prefixSum[right];
            } else {
                result[i] = prefixSum[right] - prefixSum[left - 1];
            }
        }

        return result;
    }


    private boolean isVowel(char a){
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }

}