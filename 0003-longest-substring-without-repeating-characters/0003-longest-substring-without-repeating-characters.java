class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int[] hash = new int[256];
        int left=0,right=0,n=arr.length,maxlen=0;

        while(right < n){
            while(hash[arr[right]] > 0){
                hash[arr[left]]--;
                left++;
            }
            hash[arr[right]]++;
            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }
}