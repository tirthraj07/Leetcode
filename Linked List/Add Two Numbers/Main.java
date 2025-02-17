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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode prev = null;
        ListNode head = l1;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            prev.next = l2;
            l1 = l2;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;
        }

        if (carry != 0) {
            prev.next = new ListNode(carry);
        }

        return head;
    }
}