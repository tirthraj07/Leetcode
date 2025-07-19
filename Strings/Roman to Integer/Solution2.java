import java.util.Map;

class Solution {
    public static Map<String, Integer> romanValues = Map.of(
        "I", 1,
        "V", 5,
        "X", 10,
        "L", 50,
        "C", 100,
        "D", 500,
        "M", 1000
    );
    
    public int romanToInt(String s) {
        int i = 0;
        int ans = 0;
        int prev = Integer.MAX_VALUE;
        while(i < s.length()){
            Integer numberVal = romanValues.get(Character.toString(s.charAt(i)));

            if(prev < numberVal){
                ans += numberVal - 2*prev;
            }
            else {
                ans += numberVal;
            }

            prev = numberVal;
            i+= 1;
        }
        return ans;
    }   
}