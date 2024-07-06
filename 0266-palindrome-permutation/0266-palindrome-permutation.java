class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s.length()==1) return true;
        int[] chars = new int[26];
        for(char c : s.toCharArray()){
            chars[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(chars[i]>0){
                if(chars[i] % 2== 0){
                    chars[i]=0;
                }else{
                    if(chars[i] > 1){
                        chars[i] = 1;
                    }
                }
            }
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(chars[i]>0){
                count++;
            }
        }


        return count > 1 ? false : true;
    }
}