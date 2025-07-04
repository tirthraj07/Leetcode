class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        while(j < nums.length){
            if(nums[j] == 0){
                swap(i,j,nums);
            }
            j++;
        }

        j = i;
        while(j < nums.length){
            if(nums[j] == 1){
                swap(i,j,nums);
            }
            j++;
        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}