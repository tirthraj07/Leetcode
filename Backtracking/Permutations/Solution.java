import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    if (nums.length == 0) {
      List<Integer> row = new LinkedList<>();
      List<List<Integer>> res = new LinkedList<>();
      res.add(row);
      return res;
    }

    List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
    int valueToBeInserted = nums[0];
    List<List<Integer>> result = new LinkedList<>();

    for (List<Integer> perm : perms) {
      for (int i = 0; i <= perm.size(); i++) {
        List<Integer> permCopy = new LinkedList<>(perm);
        permCopy.add(i, valueToBeInserted);
        result.add(permCopy);
      }
    }

    return result;
  }
}
