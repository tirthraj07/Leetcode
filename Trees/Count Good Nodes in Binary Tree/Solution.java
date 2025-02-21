import java.util.LinkedList;
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

// DFS Approach
class Solution {
	private int count = 0;

	private void dfs(TreeNode root, int max) {
		if (root == null)
			return;

		if (root.val >= max) {
			count += 1;
			max = root.val;
		}

		dfs(root.left, max);
		dfs(root.right, max);
	}

	public int goodNodes(TreeNode root) {
		if (root == null)
			return 0;
		int max = Integer.MIN_VALUE;
		dfs(root, max);
		return count;
	}
}

// BFS Approach
class Solution2 {
	private class Pair<K, V> {
		public K first;
		public V second;

		public Pair(K first, V second) {
			this.first = first;
			this.second = second;
		}
	}

	public int goodNodes(TreeNode root) {
		if (root == null)
			return 0;

		int count = 0;
		Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
		q.offer(new Pair<TreeNode, Integer>(root, Integer.MIN_VALUE));

		while (!q.isEmpty()) {
			Pair<TreeNode, Integer> pair = q.poll();
			TreeNode node = pair.first;
			Integer max = pair.second;
			if (node.val >= max) {
				count += 1;
				max = node.val;
			}
			if (node.left != null)
				q.offer(new Pair<TreeNode, Integer>(node.left, max));
			if (node.right != null)
				q.offer(new Pair<TreeNode, Integer>(node.right, max));
		}

		return count;
	}
}