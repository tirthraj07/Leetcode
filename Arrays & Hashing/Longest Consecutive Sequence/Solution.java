import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums){
            set.add(num);
        }


        int maxCount = 0;
        int currentCount = 0;
        for(int num: set){
            if(!set.contains(num - 1)){
                currentCount = 1;
                int n = num + 1;
                while(set.contains(n)){
                    currentCount += 1;
                    n += 1;
                }
                maxCount = Math.max(maxCount, currentCount);
            }
        }

        return maxCount;
    }
}