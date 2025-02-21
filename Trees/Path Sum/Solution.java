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
    private boolean doesPathExists = false;

    private void dfs(TreeNode root, int currentSum, int targetSum) {
        if (doesPathExists == true)
            return;

        currentSum += root.val;

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum)
                doesPathExists = true;
            return;
        }
        if (root.left != null)
            dfs(root.left, currentSum, targetSum);
        if (root.right != null)
            dfs(root.right, currentSum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        int currentSum = 0;
        dfs(root, currentSum, targetSum);

        return doesPathExists;
    }
}

// Much Cleaner Solution
class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}