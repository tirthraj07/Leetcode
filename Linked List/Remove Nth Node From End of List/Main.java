public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

@SuppressWarnings("all")
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy;
        ListNode after = dummy;

        for (int i = 0; i <= n; i++) {
            after = after.next;
        }

        while (after != null) {
            before = before.next;
            after = after.next;
        }

        before.next = before.next.next;

        return dummy.next;
    }
}