public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    @SuppressWarnings("all")
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (slow == fast)
                return true;

            slow = slow.next;
            if (fast.next == null)
                return false;
            fast = fast.next.next;
        }

        return false;
    }
}