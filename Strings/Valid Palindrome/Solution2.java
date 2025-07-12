class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char l_ch = s.charAt(i);
            char r_ch = s.charAt(j);

            if(!Character.isLetterOrDigit(l_ch)){
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(r_ch)){
                j--;
                continue;
            }
            
            if(Character.toLowerCase(l_ch) != Character.toLowerCase(r_ch)){
                return false;
            }

            i++;
            j--;    
        }
        
        return true;
    }
}