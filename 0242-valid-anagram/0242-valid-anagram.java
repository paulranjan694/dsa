class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charsFreq = new int[26];
        if(s.length() != t.length()) return false;

        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        for(int i = 0;i<s.length();i++){
            charsFreq[sarr[i] - 'a']++;
            charsFreq[tarr[i] - 'a']--;
        }

        for(int i = 0;i<26;i++){
            if(charsFreq[i] > 0){
                return false;
            }
        }

        return true;
    }
}