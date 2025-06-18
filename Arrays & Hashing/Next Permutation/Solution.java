class Solution {
    public void nextPermutation(int[] nums) {
        int i = findBreakPoint(nums);
        if(i == -1){
            reverseArray(nums, 0, nums.length - 1);
            return;
        }

        int idx = findMinGreaterThan(nums, i);

        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;

        reverseArray(nums, i+1, nums.length - 1);
    }

    private void reverseArray(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    private int findBreakPoint(int[] nums){
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                return i;
            }
        }
        return -1;
    }

    private int findMinGreaterThan(int[] nums, int i){
        int low = i+1;
        int high = nums.length - 1;

        int ans = high;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid]>nums[i]){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return ans;
    }

}