class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int element = entry.getKey();
            int idx = entry.getValue();
            buckets.get(idx).add(element);
        }

        int[] sol = new int[k];
        int n = k;
        for(int i=nums.length; i>=0; i--){
            if(k <= 0){
                break;
            }

            List<Integer> vals = buckets.get(i);
            if(vals.isEmpty()){
                continue;
            }

            for(int j=0; j<vals.size() && k > 0; j++, k--){
                sol[n-k] = vals.get(j);
            }
        }

        return sol;
    }
}
