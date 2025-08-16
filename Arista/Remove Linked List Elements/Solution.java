class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }       
        
        if(head == null){
            return null;
        }

        ListNode curr = head;
        while(curr.next !=null){
            if(curr.next.val == val){
                ListNode next = curr.next;
                while(next!= null && next.val == val){
                    next = next.next;
                }
                curr.next = next;
            }
            curr = curr.next;
        }

        return head;
    }
}