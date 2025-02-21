import java.util.ArrayList;
import java.util.List;

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
    private boolean helper(TreeNode minNode, TreeNode root, TreeNode maxNode) {
        if (root == null)
            return true;

        if (minNode != null && root.val <= minNode.val)
            return false;

        if (maxNode != null && root.val >= maxNode.val)
            return false;

        return helper(minNode, root.left, root) && helper(root, root.right, maxNode);

    }

    public boolean isValidBST(TreeNode root) {
        return helper(null, root, null);
    }
}

class Solution2 {

    private boolean helper(long min, TreeNode root, long max) {
        if (root == null)
            return true;

        if (min >= root.val || max <= root.val)
            return false;

        return helper(min, root.left, root.val) && helper(root.val, root.right, max);

    }

    public boolean isValidBST(TreeNode root) {
        return helper(Long.MIN_VALUE, root, Long.MAX_VALUE);
    }
}

class Solution3 {
    List<Integer> array = new ArrayList<>();

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        array.add(root.val);
        inorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        inorder(root);

        int i = 1;
        int n = array.size();
        while (i < n) {
            if (array.get(i - 1) >= array.get(i))
                return false;
            i++;
        }
        return true;
    }
}