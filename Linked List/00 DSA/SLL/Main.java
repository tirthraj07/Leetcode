package SLL;

public class Main {
    public static void main(String[] args) {
        SLL linkedList = new SLL();
        System.out.println(linkedList);

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);

        linkedList.remove(4);
        System.out.println(linkedList);

        linkedList.remove(5);
        System.out.println(linkedList);

        linkedList.remove(10);
        System.out.println(linkedList);

    }
}

class SLLNode {
    public int val;
    public SLLNode next;

    public SLLNode(int val) {
        this.val = val;
        this.next = null;
    }

    public SLLNode(int val, SLLNode next) {
        this.val = val;
        this.next = next;
    }
}

class SLL {
    SLLNode head;

    public SLL() {
        this.head = null;
    }

    public void add(int val) {
        SLLNode newNode = new SLLNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void remove(int val) {
        SLLNode prev = null;
        SLLNode curr = head;
        while (curr != null && curr.val != val) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Element not found");
            return;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        SLLNode curr = head;
        while (curr != null) {
            str.append(curr.val).append(" ");
            curr = curr.next;
        }
        return str.toString().trim();
    }

}