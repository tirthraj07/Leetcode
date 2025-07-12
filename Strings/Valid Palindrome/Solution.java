class Solution {
    private boolean isPalindromeString(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i!=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private char toLower(char c){
        return (char)('a' + (c - 'A'));
    }   

    private boolean isAlphanumeric(char ch){
        if(ch >= 'a' && ch <= 'z'){
            return true;
        }
        else if(ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }

    private String formatString(String s){
        StringBuilder formattedString = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(isAlphanumeric(ch)){
                formattedString.append(ch);
            } else if(ch >= 'A' && ch <= 'Z'){
                formattedString.append(toLower(ch));
            }
        }

        return formattedString.toString();
    }

    public boolean isPalindrome(String s) {
        return isPalindromeString(formatString(s));
    }
}