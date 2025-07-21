class Solution {
    public int[] insertionSort(int[] nums) {
        if(nums.length < 2){
            return nums;
        }

        // Insertion Sort - Increases the subarray in each iteration and places the new element in right position inside the subarray
        
        for(int i=1; i<nums.length; i++){
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }

        return nums;
    }
}