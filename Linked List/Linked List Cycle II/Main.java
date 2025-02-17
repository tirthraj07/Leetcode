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
	public ListNode detectCycle(ListNode head) {

		// Floyds Algorithm to find the start of cycle
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}

		if (fast == null || fast.next == null)
			return null;

		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}
}