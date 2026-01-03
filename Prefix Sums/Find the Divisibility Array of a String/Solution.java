class Solution {
    public int[] divisibilityArray(String word, int m) {
        long prefixSum = 0;
        int[] result = new int[word.length()];

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int num = c - '0';
            prefixSum = (prefixSum * 10 + num) % m;
            result[i] = (prefixSum%m==0)?1:0;
            
        }

        return result;
    }
}