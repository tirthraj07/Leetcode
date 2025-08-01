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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        preorderTraversal(root, sol);
        return sol;
    }

    private void preorderTraversal(TreeNode root, List<Integer> sol){
        if(root == null){
            return;
        }

        sol.add(root.val);
        preorderTraversal(root.left, sol);
        preorderTraversal(root.right, sol);
    }
}