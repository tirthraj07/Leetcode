class Solution {
    public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int numZeros = 0;
		for(int num: nums){
			if(num == 0){
				numZeros += 1;
			}

			if(numZeros < 2){
				product *= (num == 0) ? 1 : num;
			} else {
				product = 0;
				break;
			}
		}

		int[] sol = new int[nums.length];

		for(int i = 0; i<nums.length; i++){
			if(numZeros>=2){
				sol[i] = 0;
			} else if(numZeros == 1 && nums[i] == 0){
				sol[i] = product;
			} else if(numZeros == 1){
				sol[i] = 0;
			} else {
				sol[i] = product/nums[i];
			}
		}	
		return sol;

    }
}
