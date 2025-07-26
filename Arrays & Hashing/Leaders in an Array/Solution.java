// Leaders in an Array
/*
Given an integer array nums, return a list of all the leaders in the array.

A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. 
The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array. 

Input: nums = [1, 2, 5, 3, 1, 2]
Output: [5, 3, 2]
Explanation: 2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]
*/

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> sol = new ArrayList<>();

        int currentMax = nums[nums.length - 1];
        sol.add(currentMax);
        for(int i=nums.length - 1; i>=0; i--){
            if(nums[i] > currentMax){
                sol.add(nums[i]);
                currentMax = nums[i];
            }
        }
        
        Collections.reverse(sol);

        return sol;
    }
}