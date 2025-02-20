import java.util.Stack;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> p_st = new Stack<>();
        Stack<TreeNode> q_st = new Stack<>();
        p_st.add(p);
        q_st.add(q);

        while (!p_st.isEmpty() && !q_st.isEmpty()) {
            p = p_st.pop();
            q = q_st.pop();

            if (p == null && q == null) {
                continue;
            } else if (p == null || q == null) {
                return false;
            } else if (p.val != q.val) {
                return false;
            }

            if (p.left != null && q.left != null) {
                p_st.push(p.left);
                q_st.push(q.left);
            } else if (p.left != null || q.left != null) {
                return false;
            }

            if (p.right != null && q.right != null) {
                p_st.push(p.right);
                q_st.push(q.right);
            } else if (p.right != null || q.right != null) {
                return false;
            }
        }

        return p_st.isEmpty() && q_st.isEmpty();
    }
}