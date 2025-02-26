class Solution {
    private List<List<Integer>> sol;
    private List<Integer> subset;
    private int[] nums;

    private void dfs(int index){
        if(index == nums.length){
            sol.add(List.copyOf(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(index + 1);

        subset.removeLast();
        int i = 1;
        while((index + i) < nums.length && nums[index] == nums[index+i]) i++;

        if((index+i)<=nums.length)
            dfs(index+i);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        sol = new ArrayList<>();
        subset = new LinkedList<>();
        this.nums = nums;
        dfs(0);
        return sol;
    }
}
