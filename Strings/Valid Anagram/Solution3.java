import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(Character c: s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for(Character c: t.toCharArray()){
            if(!freq.containsKey(c) || freq.get(c) == 0){
                return false;
            }
            freq.put(c, freq.get(c) - 1);
        }

        for(Entry<Character, Integer> set : freq.entrySet()){
            if(set.getValue() != 0){
                return false;
            }
        }

        return true;
    }   
}
