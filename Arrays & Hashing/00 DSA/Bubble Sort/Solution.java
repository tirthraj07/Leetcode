class Solution {
    public int[] bubbleSort(int[] nums) {
        // Push the max to the last by adjecent swaps

        for(int i=0; i<nums.length - 1; i++){
            for(int j=0; j<nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return nums;
    }
}