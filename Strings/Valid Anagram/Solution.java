class Solution {
    public boolean isAnagram(String s, String t) {
		int[] alphabet_occur = new int[26];
		for(int i = 0; i<s.length(); i++){
			int idx = s.charAt(i)-'a';
			alphabet_occur[idx] += 1;
		}
		

		for(int i=0; i<t.length(); i++){
			int idx = t.charAt(i)-'a';
			alphabet_occur[idx] -= 1;
		}

		
		for(int i=0; i<26; i++){
			if(alphabet_occur[i]!=0){
				return false;
			}
		}

		return true;
    }
}
