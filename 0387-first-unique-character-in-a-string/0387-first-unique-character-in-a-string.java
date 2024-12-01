class Solution {
    public int firstUniqChar(String s) {
        int[] charfreq = new int[27];
        char [] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            charfreq[chars[i]-'a']++;
        }
        
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(charfreq[chars[i]-'a'] == 1) return i;
        }
        return -1;
    }
}