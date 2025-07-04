class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];

        for(char c : s.toCharArray()){
            hash[c-'a']++;
        }

        for(char c : t.toCharArray()){
            hash[c-'a']--;
        }

        for(int i=0;i<26;i++){
            if(hash[i] != 0){
                return false;
            }
        }
        return true;
    }
}