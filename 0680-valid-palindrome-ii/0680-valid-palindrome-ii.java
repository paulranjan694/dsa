class Solution {
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1,count=0;

        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;j--;
            }else{
                return isValidPalindrom(s,i+1,j) || isValidPalindrom(s,i,j-1);
            }
        }
        return true;
    }

    public boolean isValidPalindrom(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;j--;
            }else{
                return false;
            }
        }
        return true;
    }
}