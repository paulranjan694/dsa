class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLen = 0;
        int i=0,j=0,n=s.length();
        while(j<n){
            freq[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(j) - 'A']);
            if((j-i+1)-maxFreq > k){
                freq[s.charAt(i) - 'A']--;
                i++;
                for(int l = 0;l<26;l++){
                    maxFreq = Math.max(freq[l],maxFreq);
                }
            }
            if((j-i+1)-maxFreq <= k){
                maxLen = Math.max(maxLen,(j-i+1));
            }
            j++;
        }
        return maxLen;
    }
}