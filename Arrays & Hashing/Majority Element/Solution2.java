class Solution2 {
    public int majorityElement(int[] nums) {
        // Moore's Algorithm 
        // Time O(N) Space O(1)
        int candidate = 0;
        int count = 0;
        for(int num: nums){
            if(count == 0){
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}