class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        int left=0,right=0,maxlen=0,n=s.length();
        while(right < n){
            char ch = s.charAt(right);
            hash[ch]++;
            if(hash[ch] <= 1){
                maxlen = Math.max(maxlen,right-left+1);
            }else{
                boolean duplicate = true;
                while(duplicate){
                    char c = s.charAt(left);
                    hash[c]--;
                    boolean containsdup = false;
                    for(int i=0;i<256;i++){
                        if(hash[i] > 1){
                            containsdup=true;
                            break;
                        }
                    }
                    duplicate = containsdup==true;
                    left++;
                }
                maxlen = Math.max(maxlen,right-left+1);
            }
            right++;

        }
        return maxlen;
    }
}