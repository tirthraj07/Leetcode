class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0;
        int prefix = 0;
        for (int v : nums) {
            prefix += v & 1;
            if (prefix - k >= 0) {
                ans += cnt[prefix - k];
            }
            cnt[prefix]++;
        }
        return ans;
    }
}