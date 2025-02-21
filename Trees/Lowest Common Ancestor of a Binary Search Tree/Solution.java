import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// Most Optimal Solution. 1 Pass, O(1) Space
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode smallerNode = p.val < q.val ? p : q;
        TreeNode biggerNode = smallerNode == p ? q : p;

        // If my current node > bigger node, then move left
        // If my current node < smaller node, then move right
        // If my current node ∈ [smallerNode, biggerNode] then my current node is the
        // LCA

        while (root != null) {
            if (root.val < smallerNode.val)
                root = root.right;
            else if (root.val > biggerNode.val)
                root = root.left;
            else
                return root;
        }

        return root;
    }
}

// Not Optimal. Traces the path till p and q and then finds the last common
// ancestor using path stored in list
class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = new LinkedList<>();
        List<TreeNode> qAncestors = new LinkedList<>();

        TreeNode curr = root;
        while (curr != p) {
            pAncestors.add(curr);
            if (curr.val < p.val)
                curr = curr.right;
            else
                curr = curr.left;
        }
        pAncestors.add(p);

        curr = root;
        while (curr != q) {
            qAncestors.add(curr);
            if (curr.val < q.val)
                curr = curr.right;
            else
                curr = curr.left;
        }
        qAncestors.add(q);

        int i = 0;

        while (i < pAncestors.size() && i < qAncestors.size()) {
            if (pAncestors.get(i) != qAncestors.get(i)) {
                return pAncestors.get(i - 1);
            }
            i++;
        }

        return pAncestors.get(i - 1);
    }
}
