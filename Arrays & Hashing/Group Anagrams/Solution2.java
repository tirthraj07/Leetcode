class Solution {
	public List<List<String>> groupAnagrams(String[] strs){
		Map<String, List<String>> map = new HashMap<>();
		
		for(String str: strs){
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sortedString = new String(charArray);
			map.putIfAbsent(sortedString, new ArrayList<>());
			map.get(sortedString).add(str);
		}
		
		List<List<String>> sol = new ArrayList<>();
		for(List<String> val: map.values()){
			sol.add(val);
		}

		return sol;

	}
	
}
