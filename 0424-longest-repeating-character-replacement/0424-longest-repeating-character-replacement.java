class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];

        char[] arr = s.toCharArray();
        int left=0,right=0,n=arr.length,maxLen=0,maxFreq=0;

        while(right < n){
            hash[arr[right]-'A']++;
            maxFreq = Math.max(maxFreq,hash[arr[right]-'A']);
            while(right-left+1 - maxFreq> k){
                hash[arr[left]-'A']--;
                left++;
                for(int i=0;i<26;i++){
                    maxFreq=Math.max(hash[i],maxFreq);
                }
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }  
        return maxLen;
    }
}