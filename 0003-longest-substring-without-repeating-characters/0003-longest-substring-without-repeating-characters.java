class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l=0,r=0,maxlen=0;
        int[] hash = new int[256];
        Arrays.fill(hash,-1);

        while(r<n){
            char ch = s.charAt(r);
            if(hash[ch] != -1){
                if(hash[ch] >= l){
                    l = hash[ch] + 1;
                }
            }
            hash[ch] = r;
            maxlen=Math.max(maxlen, (r-l+1));
            r++;
        }
        return maxlen;
    }
}