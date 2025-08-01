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

/*
We know that Post Order is : Left, Right and Root
That makes the Postorder tricky
But if we solve in reverse mannar i.e Root Right Left
It is quite similar to preorder's Root Left Right

So we can use the same approach of preorder
And store the result in the stack, and then reverse the stack
*/


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        if(root == null){
            return sol;
        }
        Stack<TreeNode> resultStack = new Stack<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            resultStack.add(curr);

            if(curr.left != null) st.add(curr.left);
            if(curr.right != null) st.add(curr.right);
        }

        while(!resultStack.isEmpty()){
            sol.add(resultStack.pop().val);
        }

        return sol;
    }
}