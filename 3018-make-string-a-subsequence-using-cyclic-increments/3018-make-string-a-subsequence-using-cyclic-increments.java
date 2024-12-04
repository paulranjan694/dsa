class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        
        if(str2.length() > str1.length()) return false;

        int i=0,j=0;
        while(i<l1 && j<l2){
            char ch1=str1.charAt(i);
            char ch2=str2.charAt(j);
            char c = (char)(('a'+((ch1-'a')+1)%26));
            if(ch1==ch2 || c == ch2){
                j++;
            }
            i++;
        }

        if(j == l2) return true;
        return false;

    }
}