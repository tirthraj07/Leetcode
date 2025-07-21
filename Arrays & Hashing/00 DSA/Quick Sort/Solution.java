class Solution {
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right){
        if(left < right){
            int partitionIndex = partition(nums, left, right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
    }

    private int partition(int[] nums, int low, int high){
        int pivot = low;
        int j = low + 1;
        for(int i=low; i<=high; i++){
            if(nums[i] < nums[pivot]){
                swap(nums, i, j);
                j++;
            }
        }

        j = j - 1;
        swap(nums, pivot, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,4,1,3,10};

        new Solution().quickSort(nums);

        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

}