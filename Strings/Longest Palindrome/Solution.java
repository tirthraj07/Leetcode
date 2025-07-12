import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int longestPalindrome(String s) {
 		Map<Character, Integer> occur = new HashMap<>();
		
		for(Character c: s.toCharArray()){
			occur.put(c, occur.getOrDefault(c,0)+1);
		}

		boolean addOne = false;
		int count = 0;

		for(Entry<Character, Integer> set: occur.entrySet()){
			if(set.getValue()%2==1){
				addOne = true;
			}
			count += (set.getValue() / 2)*2;
		}

		return addOne == true ? count + 1 : count;
    }
}
