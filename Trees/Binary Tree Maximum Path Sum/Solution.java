class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        // Clever way to passing by reference
        int[] maxi = {Integer.MIN_VALUE};
        maxPathSum(root, maxi);
        return maxi[0];
    }

    private int maxPathSum(TreeNode root, int[] maxi){
        if(root == null){
            return 0;
        }

        int lps = Math.max(0, maxPathSum(root.left, maxi));
        int rps = Math.max(0,maxPathSum(root.right, maxi));
        int currPathSum = root.val + lps + rps;
        if(currPathSum > maxi[0]){
            maxi[0] = currPathSum;
        }

        return root.val + Math.max(lps, rps);
    }
}