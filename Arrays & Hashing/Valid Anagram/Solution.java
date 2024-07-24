import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        s = new String(sArray);
        t = new String(tArray);
        return s.equals(t);
    }
}