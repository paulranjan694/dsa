class Solution {
    public int firstUniqChar(String s) {
        int[] charfreq = new int[27];
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            charfreq[ch-'a']++;
        }
        
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(charfreq[ch-'a'] == 1) return i;
        }
        return -1;
    }
}