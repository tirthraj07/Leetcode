import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int height = 0;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node != null) {
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            } else {
                height += 1;
                if (!q.isEmpty())
                    q.add(null);
            }
        }

        return height;

    }
}