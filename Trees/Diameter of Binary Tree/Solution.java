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

public class Solution {
    private int maxDiameter = 0;

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int l_height = height(root.left);
        int r_height = height(root.right);
        maxDiameter = Math.max(maxDiameter, l_height + r_height);
        return 1 + Math.max(l_height, r_height);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDiameter, height(root.left) + height(root.right));

    }
}