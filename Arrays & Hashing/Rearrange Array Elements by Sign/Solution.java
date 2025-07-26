class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] sol = new int[nums.length];
        int pIndex = 0;
        int nIndex = 1;
        for(int num: nums){
            if(num >= 0){
                sol[pIndex] = num;
                pIndex += 2;
            } else {
                sol[nIndex] = num;
                nIndex += 2;
            }
        }

        return sol;
    }
}