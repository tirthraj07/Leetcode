class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        // Store prefix first
        for(int i=1; i<n; i++){
            result[i] = result[i-1] * nums[i-1];
        }
        // Keep a running suffix product
        int suffixProduct = nums[n-1];
        for(int i=n-2; i>=0; i--){
            result[i] = suffixProduct * result[i];
            suffixProduct *= nums[i];
        }
        

        return result;  
    }
}