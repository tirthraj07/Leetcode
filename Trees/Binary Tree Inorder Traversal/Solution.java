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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        inorderTraversal(root, sol);
        return sol;
    }

    private void inorderTraversal(TreeNode root, List<Integer> sol){
        if(root == null){
            return;
        }

        inorderTraversal(root.left, sol);
        sol.add(root.val);
        inorderTraversal(root.right, sol);
    }
}