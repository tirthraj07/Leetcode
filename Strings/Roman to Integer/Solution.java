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
        while(i < s.length()){
            Integer numberVal = romanValues.get(Character.toString(s.charAt(i)));
            Integer nextNumberVal = i==s.length() - 1 ? 0 : romanValues.get(Character.toString(s.charAt(i + 1)));

            if(nextNumberVal > numberVal){
                ans += nextNumberVal - numberVal;
                i += 2;
            }
            else {
                ans += numberVal;
                i += 1;
            }
        }
        return ans;
    }   
}