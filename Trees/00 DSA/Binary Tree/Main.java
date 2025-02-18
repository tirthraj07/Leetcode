class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Main {
    public static void inorderTraverse(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        inorderTraverse(root.left);
        inorderTraverse(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.right.left = new Node(3);
        root.right.right = new Node(5);

        inorderTraverse(root);

    }

}
