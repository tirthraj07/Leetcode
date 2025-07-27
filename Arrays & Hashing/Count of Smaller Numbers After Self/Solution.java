// This solution results in Time Limit Exceeded

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
 		List<Integer> sol = new ArrayList<Integer>();
		for(int i=0; i<nums.length; i++){
			int count = 0;
			for(int j=i+1; j<nums.length; j++){
				if(nums[j]<nums[i]){
					count++;
				}
			}
			sol.add(count);
		}

		return sol;
    }
}
