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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (head == null) {
                    head = new ListNode(list1.val);
                    curr = head;
                } else {
                    curr.next = new ListNode(list1.val);
                    curr = curr.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = new ListNode(list2.val);
                    curr = head;
                } else {
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                }
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            if (head == null) {
                head = list1;
                curr = head;
            } else {
                curr.next = list1;

            }
            return head;
        }

        if (list2 != null) {
            if (head == null) {
                head = list2;
                curr = head;
            } else {
                curr.next = list2;
                curr = curr.next;
            }
            return head;
        }

        return head;
    }
}