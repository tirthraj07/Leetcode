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

class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> sol = new ArrayList<>();
		if (root == null)
			return sol;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);

		int lastSeenNode = root.val;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node != null) {
				lastSeenNode = node.val;
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			} else {
				sol.add(lastSeenNode);
				if (!q.isEmpty())
					q.add(null);
			}

		}
		return sol;
	}
}

class Solution2 {
	private List<List<Integer>> levels = new ArrayList<>();

	private void helper(TreeNode root, int level) {
		if (levels.size() == level) {
			levels.add(new ArrayList<Integer>());
		}
		levels.get(level).add(root.val);
		if (root.left != null)
			helper(root.left, level + 1);
		if (root.right != null)
			helper(root.right, level + 1);
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightSideNodes = new ArrayList<>();
		if (root == null)
			return rightSideNodes;

		helper(root, 0);

		for (int i = 0; i < levels.size(); i++) {
			int n = levels.get(i).size();
			rightSideNodes.add(levels.get(i).get(n - 1));
		}

		return rightSideNodes;
	}

}

// Optimization over Solution2
class Solution3 {
	List<Integer> rightSideNodes = new ArrayList<>();

	private void helper(TreeNode root, int level) {
		if (rightSideNodes.size() == level) {
			rightSideNodes.add(root.val);
		}
		if (root.right != null)
			helper(root.right, level + 1);

		if (root.left != null)
			helper(root.left, level + 1);

	}

	public List<Integer> rightSideView(TreeNode root) {

		if (root == null)
			return rightSideNodes;

		helper(root, 0);

		return rightSideNodes;
	}

}
