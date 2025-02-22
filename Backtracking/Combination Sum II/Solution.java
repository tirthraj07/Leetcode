import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
	private ArrayList<List<Integer>> sol;
	private LinkedList<Integer> subset;
	private int[] candidates;

	private void dfs(int index, int currentSum, int target) {
		if (currentSum == target) {
			sol.add(List.copyOf(subset));
			return;
		}
		if (index == candidates.length || currentSum > target) {
			return;
		}

		subset.add(candidates[index]);
		currentSum += candidates[index];

		dfs(index + 1, currentSum, target);

		subset.removeLast();
		currentSum -= candidates[index];

		int i = 1;
		while ((index + i) < candidates.length && candidates[index + 1] == candidates[index])
			i++;

		if ((index + i) < candidates.length)
			dfs(index + i, currentSum, target);

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		sol = new ArrayList<>();
		subset = new LinkedList<>();
		this.candidates = candidates;

		dfs(0, 0, target);

		return new ArrayList<>(sol);

	}
}