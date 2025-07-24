class Solution {
    public int[] productExceptSelf(int[] nums) {
 		int[] prefixProduct = new int[nums.length];
		int[] suffixProduct = new int[nums.length];
		prefixProduct[0] = 1;
		suffixProduct[nums.length-1] = 1;
		
		for(int i=1; i<nums.length; i++){
			int rdx = nums.length - 1 - i;
			prefixProduct[i] = prefixProduct[i-1]*nums[i-1];
			suffixProduct[rdx] = suffixProduct[rdx + 1] * nums[rdx + 1];
		}
		
		int[] sol = new int[nums.length];
		for(int i=0; i<nums.length; i++){
			sol[i] = prefixProduct[i] * suffixProduct[i];
		}


		return sol;
    }
}
