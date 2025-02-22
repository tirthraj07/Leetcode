import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
	private List<List<Integer>> sol;
	private LinkedList<Integer> subset;
	private int[] candidates;

	private void dfs(int index, int currentSum, int target) {
		if (index == candidates.length) {
			return;
		}

		if (currentSum > target) {
			return;
		}

		else if (currentSum == target) {
			sol.add(List.copyOf(subset));
			return;
		}

		currentSum += candidates[index];
		subset.add(candidates[index]);

		dfs(index, currentSum, target);

		subset.removeLast();
		currentSum -= candidates[index];
		dfs(index + 1, currentSum, target);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		sol = new ArrayList<>();
		subset = new LinkedList<>();
		int index = 0;
		this.candidates = candidates;

		dfs(index, 0, target);

		return sol;
	}
}
