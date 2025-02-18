import java.util.Stack;

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

// Recursive Solution
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(left);
        invertTree(right);

        return root;
    }
}

// Iterative Solution
class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.empty()) {
            TreeNode node = st.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) {
                st.push(left);
            }
            if (right != null) {
                st.push(right);
            }
        }
        return root;
    }
}