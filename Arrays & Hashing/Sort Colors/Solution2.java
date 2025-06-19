class Solution2 {
    public void sortColors(int[] nums) {
        
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while(k >= j){
            if(nums[j] == 0){
                swap(i, j, nums);
                i++;
                j++;
            }
            else if(nums[j] == 2){
                swap(j,k,nums);
                k--;
            }
            else {
                j++;
            }
        }
        
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}