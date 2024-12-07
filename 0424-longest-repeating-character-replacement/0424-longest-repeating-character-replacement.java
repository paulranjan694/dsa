class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxlen=0,n=s.length(),maxfreq=0;
        int[] hash = new int[26];
        while(r<n){
            char ch = s.charAt(r);
            hash[ch-'A']++;
            maxfreq = Math.max(maxfreq,hash[ch-'A']);
            while((r-l+1) - maxfreq > k){
                char ch1 = s.charAt(l);
                hash[ch1-'A']--;
                for(int i=0;i<26;i++){
                    maxfreq = Math.max(maxfreq,hash[i]);
                }
                l++;
            }

            if((r-l+1) - maxfreq <= k){
                maxlen = Math.max(maxlen,(r-l+1));
            }
            r++;
        }
        return maxlen;
    }
}