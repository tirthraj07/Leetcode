import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = Integer.MIN_VALUE;
        Integer candidate2 = Integer.MIN_VALUE;
        int counter1 = 0;
        int counter2 = 0;

        for(int i=0; i<nums.length; i++){
            if(counter1 == 0 && nums[i] != candidate2){
                candidate1 = nums[i];
                System.out.println("Candidate1 = " + candidate1);
                counter1 = 1;
            }
            else if(counter2 == 0 && nums[i] != candidate1){
                candidate2 = nums[i];
                System.out.println("Candidate2 = " + candidate2);
                counter2 = 1;
            }
            else if(candidate1 == nums[i]){
                counter1++;
            }
            else if(candidate2 == nums[i]){
                counter2++;
            }
            else {
                counter1--;
                counter2--;
            }
        }

        List<Integer> sol = new ArrayList<>();
        int nBy3 = nums.length / 3;
        int occurrence1 = 0;
        int occurrence2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == candidate1){
                occurrence1++;
            }
            else if(nums[i] == candidate2){
                occurrence2++;
            }
        }
        if(occurrence1 > nBy3){
            sol.add(candidate1);
        }
        if(occurrence2 > nBy3){
            sol.add(candidate2);
        }
        return sol;
    }
}