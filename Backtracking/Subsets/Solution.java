import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
	private List<List<Integer>> sol;
	private LinkedList<Integer> subset;
	private int[] nums;

	private void dfs(int index) {
		if (index == nums.length) {
			sol.add(List.copyOf(subset));
			return;
		}
		subset.add(nums[index]);
		dfs(index + 1);
		subset.removeLast();
		dfs(index + 1);
	}

	public List<List<Integer>> subsets(int[] nums) {
		this.sol = new ArrayList<>();
		this.subset = new LinkedList<>();
		this.nums = nums;
		int index = 0;
		dfs(index);

		return sol;
	}
}
