import java.util.*;
class Solution {
    public long countBadPairs(int[] nums) {
        /*
            Total number of pairs = (n*(n-1))/2;

            Now we calculate good pairs, where j-i = nums[j] - nums[i]

            What does this actually mean? j-i = nums[j] - nums[i] 
            Lets rearrange => (nums[j] - nums[i])/(j-i) = slope = 1
            i.e the points lie on the same line with slope 1
            By calculating c = y - mx
            knowing m=1, we get c = y - x, or in our array terms: c = nums[i] - i.
            Therefore, any points that share the same y-intercept (c) lie on the same line

            Another way of looking at this:
            j-i = nums[j] - nums[i]
            This equation is computationally expensive because it entangles i and j. 
            To optimize this, we must separate the variables, 
            moving all terms related to i to one side and all terms related to j to the other.
            Therefore: nums[j] - j = nums[i] - i
            We have effectively defined a transformation function f(x) = nums[x] - x
            The condition for a "Good Pair" simplifies to finding indices where: f(i) = f(j)
        */

        int n = nums.length;
        
        long totalPairs = (long) n * (n - 1) / 2;
        
        long goodPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int c = nums[i] - i;
            int count = map.getOrDefault(c, 0);
            goodPairs += count;
            map.put(c, count + 1);
        }

        return totalPairs - goodPairs;
    }
}