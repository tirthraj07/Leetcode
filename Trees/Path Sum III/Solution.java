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
    int count = 0;

    private void compute(TreeNode root, double targetSum) {
        if (root == null) {
            return;
        }

        if (root.val == targetSum) {
            count += 1;
        }

        targetSum = targetSum - root.val;
        compute(root.left, targetSum);
        compute(root.right, targetSum);
    }

    private void dfs(TreeNode root, double targetSum) {
        if (root == null)
            return;
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        compute(root, targetSum);
    }

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return count;
    }
}