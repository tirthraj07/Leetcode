class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] sArray = s.split("\\s+"); 
        int i=0, j = sArray.length - 1;
        while(i<j){
            String temp = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = temp;
            i++;
            j--;
        }
        return String.join(" ", sArray);
    }
}