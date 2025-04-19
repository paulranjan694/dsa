class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        int n = s.length(),l=0,r=0,max=0;

        char[] arr = s.toCharArray();

        while(r<n){
            while(hash[arr[r]] > 0){
                hash[arr[l]]--;
                l++;
                max = Math.max(max,r-l);
            }
            hash[arr[r]]++;
            max = Math.max(max,r-l+1);
            r++;
        }
        max = Math.max(max,r-l);
        return max;
    }
}