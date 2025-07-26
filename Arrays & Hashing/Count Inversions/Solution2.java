class Solution {
    
    public long numberOfInversions(int[] nums) {
        return countInversions(nums, 0, nums.length - 1);
    }

    private long countInversions(int[] nums, int low, int high){
        if(low < high){
            int mid = low + (high-low)/2;
            long inversions = 0;
            inversions += countInversions(nums, low, mid);
            inversions += countInversions(nums, mid+1, high);
            inversions += merge(nums, low, mid, high);
            return inversions;
        }
        return 0;
    }

    private long merge(int[] nums, int low, int mid, int high){
        int n = mid - low + 1;
        int m = high - mid; // = high - (mid + 1) + 1 = high - mid
        int[] L = new int[n];
        int[] R = new int[m];

        for(int i=0; i<n; i++){
            L[i] = nums[low+i];
        }

        for(int j=0; j<m; j++){
            R[j] = nums[mid+1+j];
        }

        int i = 0;
        int j = 0;
        int k = low;
        long inversions = 0;

        while(i < n && j < m){
            if(L[i] <= R[j]){
                nums[k] = L[i]; 
                i++;
            }
            else {
                inversions += n - i;
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n){
            nums[k] = L[i];
            i++;
            k++;
        }

        while(j < m){
            nums[k] = R[j];
            j++;
            k++;
        }

        return inversions;
    }

}