import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> visited = new HashSet<Integer>();
        for(int num: nums){
            if(visited.contains(num)) return true;
            else visited.add(num);
        }
        return false;
    }
}