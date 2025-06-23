class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = len - 1;
        int idx = -1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[mid][0]<=target && matrix[mid][n-1]>=target){
                idx = mid;
                break;
            }
            else if(matrix[mid][0]>target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        if(idx == -1){
            return false;
        }

        low = 0;
        high = n - 1;
        while (low <= high){
            int mid = (low+high)/2;
            if(matrix[idx][mid]==target){
                return true;
            }
            else if(matrix[idx][mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return false;
    }
}