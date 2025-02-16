public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
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

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr.next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        return curr;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        /*
         * 1. Find the middle of linked list
         * 2. Reverse the list from the middle
         * 3. Rearrange the nodes
         */

        ListNode list1 = head;
        ListNode middle = this.findMiddle(head);
        ListNode list2 = this.reverseList(middle);

        while (list1 != null && list2 != null) {
            ListNode l1Next = list1.next;
            ListNode l2Next = list2.next;
            list2.next = list1.next;
            list1.next = list2;
            list1 = l1Next;
            list2 = l2Next;
        }

    }
}