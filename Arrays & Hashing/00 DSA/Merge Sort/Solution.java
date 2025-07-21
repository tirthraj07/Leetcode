class Solution {
    public int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right){
        int l1 = mid - left + 1;
        int l2 = right - mid;

        int[] L = new int[l1];
        int[] R = new int[l2];

        for(int i=0; i<l1; i++){
            L[i] = nums[left+i];
        }

        for(int i=0; i<l2; i++){
            R[i] = nums[mid+1+i];
        }

        int i=0;
        int j=0;
        int k = left;

        while(i < l1 && j < l2){
            if(L[i] <= R[j]){
                nums[k] = L[i];
                i++;
            }
            else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < l1){
            nums[k] = L[i];
            i++;
            k++;
        }

        while(j < l2){
            nums[k] = R[j];
            j++;
            k++;
        }
    }

}