class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<=j){
            if(!isAlphaNumeric(s.charAt(i))){
                i++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(j))){
                j--;
                continue;
            }
            char lch=Character.toLowerCase(s.charAt(i)), rch=Character.toLowerCase(s.charAt(j));

            if(lch==rch){
                i++;j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isAlphaNumeric(char ch){
        return ('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9');
    }
}