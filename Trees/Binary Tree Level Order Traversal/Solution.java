import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

// This is the BFS Approach.
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> solution = new ArrayList<>();

        if (root == null)
            return solution;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        List<Integer> row = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                row.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            } else {
                solution.add(row);

                /*
                 * Note to self: you cannot simply do row.clear(), you will have to create a new
                 * list
                 * This is because, when you add row to solution, it is added as a reference.
                 * So when you clear the row after, the row you inserted inside of the solution
                 * collection will also be cleared
                 */

                row = new ArrayList<>();
                if (!q.isEmpty())
                    q.add(null);
            }
        }

        return solution;
    }
}

// This is the DFS Approach
class Solution2 {
    List<List<Integer>> levelOrder = new ArrayList<>();

    private void helper(TreeNode root, int level) {
        if (levelOrder.size() == level) {
            levelOrder.add(new ArrayList<Integer>());
        }
        levelOrder.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return levelOrder;

        helper(root, 0);

        return levelOrder;
    }
}