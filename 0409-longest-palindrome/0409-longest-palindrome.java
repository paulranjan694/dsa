class Solution {
    public int longestPalindrome(String s) {
        int[] chars = new int[128];
        for (char c : s.toCharArray()) {
            chars[c]++;
        }
        int ans=0;
        int oddCount = 0;
        for(int k : chars){
            if(k % 2 == 0){
                ans+=k;
            }else{
                ans+= k-1;
                oddCount++;
            }
        }

        if(oddCount > 0)
            ans++;
        
        return ans;
    }
}