class Solution {
    public int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
    }

	private int mergeSort(int[] nums, int low, int high){
		if ( low < high ){
			int mid = low + (high - low) / 2;
			int reversePairsCount = 0;
			reversePairsCount += mergeSort(nums, low, mid);
			reversePairsCount += mergeSort(nums, mid + 1, high);
			reversePairsCount += merge(nums, low, mid, high);
			return reversePairsCount;
		}
		return 0;
	}


	private int merge(int[] nums, int low, int mid, int high){
		int n = mid - low + 1;
		int m = high - mid;
		int[] A = new int[n];
		int[] B = new int[m];
		System.arraycopy(nums, low, A, 0, n);
        System.arraycopy(nums, mid + 1, B, 0, m);
        
		int reversePairsCount = 0;
		
		// process
		int ptrA = 0;
		int ptrB = 0;
		while(ptrA < n){
			while(ptrB < m && (long) A[ptrA] > 2 * (long) B[ptrB]){
				ptrB++;
			}
			reversePairsCount += ptrB;
			ptrA++;
		}


		// sort
		int i = 0;
		int j = 0;
		int k = low;
		while(i < n && j < m){
			if(A[i] > B[j]){
				nums[k] = B[j];
				j++;
			} else {
				nums[k] = A[i];
				i++;
			}
			k++;
		}

		while( i < n){
			nums[k] = A[i];
			i++;
			k++;
		}
		
		while( j < m ){
			nums[k] = B[j];
			j++;
			k++;
		}
			
		return reversePairsCount;
	
	}

}