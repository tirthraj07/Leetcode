import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

@SuppressWarnings("all")
class Solution {
    private List<List<Integer>> sol = new ArrayList<>();

    private void dfs(TreeNode root, int currentSum, int targetSum, List<Integer> currentPath) {
        currentSum += root.val;
        currentPath.add(root.val);
        if (currentSum == targetSum && root.left == null && root.right == null) {
            sol.add(List.copyOf(currentPath));
        }

        if (root.left != null)
            dfs(root.left, currentSum, targetSum, currentPath);
        if (root.right != null)
            dfs(root.right, currentSum, targetSum, currentPath);

        currentPath.remove(currentPath.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return sol;
        List<Integer> currentPath = new LinkedList<>();
        dfs(root, 0, targetSum, currentPath);

        return sol;
    }
}