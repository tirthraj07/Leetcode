import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        if(root == null){
            return sol;
        }

        Stack<TreeNode> st = new Stack<>();
        st.add(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            sol.add(curr.val);

            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
        }

        return sol;
    }

}