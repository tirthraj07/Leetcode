import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        postorderTraversal(root, sol);
        return sol;
    }

    private void postorderTraversal(TreeNode root, List<Integer> sol){
        if(root == null){
            return;
        }

        postorderTraversal(root.left, sol);
        postorderTraversal(root.right, sol);
        sol.add(root.val);
    }
}