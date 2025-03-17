class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] charsFreq = new int[26];

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            charsFreq[ch-'a']++;
        }
        int oddCount=0;
        for(int i=0;i<26;i++){
            if((charsFreq[i] & 1 )== 1){
                oddCount++;
            }

            if(oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}