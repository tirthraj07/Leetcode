// Time Complexity - O(m*n)
// Where m is the average length of string
// And n is the length of String array
//
// Note: List<String> as key in HashMap or HashSet is a O(1) Operation as 
// List overrides the equals and hashCode method

class Solution {
    private List<Integer> getArrayFromString(String str){
        List<Integer> freq = new ArrayList<>(Collections.nCopies(26, 0));
        for(int i=0; i<str.length(); i++){
            int idx = str.charAt(i) - 'a';
            freq.set(idx, freq.get(idx) + 1);
        }

        return freq;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> map = new HashMap<>();
        for(String str: strs){
            List<Integer> arr = getArrayFromString(str);
            map.putIfAbsent(arr, new ArrayList<>());
            map.get(arr).add(str);
        }

        List<List<String>> solution = new ArrayList<>();
        for(List<String> value: map.values()){
            solution.add(value);
        }
        return solution;
    }
}
