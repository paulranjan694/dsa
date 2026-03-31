class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int left=0,right=0, n = s.length(), len=0;
        char[] arr = s.toCharArray();
        while(right < n){
            while(freq[arr[right]] > 0){
                freq[arr[left]]--;
                left++;
            }

            freq[arr[right]]++;

            len = Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}