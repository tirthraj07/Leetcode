import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

// LRU Cache Solution using Doubly Circular Linked list
class LRUCache {
    private class ListNode {
        public int key;
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity;
    private int total;
    HashMap<Integer, ListNode> map;
    ListNode head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.total = 0;

        map = new HashMap<>();

        // Implement a doubly circular linked list
        head = new ListNode(-1, -1); // dummy node
        head.next = head;
        head.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);

        // If node not found, return -1
        if (node == null) {
            return -1;
        }

        // Delete the node from its position
        node.prev.next = node.next;

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        // Set the obtained node as MRU Node -> node before head
        ListNode lastNode = head.prev;
        lastNode.next = node;
        head.prev = node;
        node.next = head;
        node.prev = lastNode;
        return head.prev.val;
    }

    public void put(int key, int value) {
        if (total == 0) {
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            total += 1;

            head.next = newNode;
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = head;

            return;
        }

        // if key already exists
        ListNode node = map.get(key);
        if (node != null) {
            // update the value
            node.val = value;

            // remove the node from its original position
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }

            // make it a MRU Node
            ListNode lastNode = head.prev;
            lastNode.next = node;
            head.prev = node;
            node.next = head;
            node.prev = lastNode;
            return;
        }

        if (total < capacity) {
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);

            // Update MRU
            ListNode lastNode = head.prev;
            lastNode.next = newNode;
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = lastNode;
            total += 1;
            return;
        }

        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);

        // Remove LRU
        ListNode lruNode = head.next;
        map.remove(lruNode.key);

        head.next = lruNode.next;
        lruNode.next.prev = head;

        // Update MRU
        ListNode lastNode = head.prev;
        lastNode.next = newNode;
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = lastNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */