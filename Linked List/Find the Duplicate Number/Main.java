public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

@SuppressWarnings("all")
class Solution {
    public int findDuplicate(int[] nums) {

        // To solve this problem, you need to know the algorithm as you cannot solve it
        // with the given constraints
        // You must solve the problem without modifying the array nums and using only
        // constant extra space.

        // Treat the index as nodes and values inside of the index as links connected to
        // them
        // example nums = [1,3,4,2,2]
        // 0 -> 3 -> 2 <=> 4
        // This means that the cycle exists in the linked list
        // All you need to do is detect the start of the cycle just like in the problem
        // Linked List Cycle II

        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}