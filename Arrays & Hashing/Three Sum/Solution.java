import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> sol = new ArrayList<>();

        for(int i=0; i<nums.length - 3; i++){
            if(i!=0 && nums[i-1] == nums[i]){
                continue;
            }
            int j = i+1;
            int k = nums.length - 1;
            while(j < k){
                if(j!=i+1 && nums[j-1] == nums[j]){
                    j++;
                    continue;
                }

                if(nums[i] + nums[j] + nums[k] == 0){
                    sol.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }
                else{
                    j++;
                }
            }


        }

        return sol;
    }
}