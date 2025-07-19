class Solution {
    public String longestPalindrome(String s) {
        
        String maxPalindrome = "";

        for(int i = 0; i<s.length(); i++){
            
            // check odd palindrome
            int l = i;
            int r = i;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxPalindrome.length()){
                    maxPalindrome = s.substring(l, r+1);
                }
                l--;
                r++;
            }

            // check even palindome
            l = i;
            r = i + 1;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxPalindrome.length()){
                    maxPalindrome = s.substring(l, r+1);
                }
                l--;
                r++;
            }

        }

        return maxPalindrome;

    }
}