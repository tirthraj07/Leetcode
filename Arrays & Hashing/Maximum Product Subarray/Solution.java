class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            max = Math.max(max, curr);
            for(int j=i+1; j<nums.length; j++){
                curr *= nums[j];
                max = Math.max(curr, max);
            }
        }

        return max;
    }
}