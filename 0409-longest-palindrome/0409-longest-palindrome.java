class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        char[] chars=s.toCharArray();

        for(int i=0;i<chars.length;i++){
            freq[chars[i]]++;
        }

        int ans=0,oddcount=0;
        for(int i=0;i<128;i++){
            if(freq[i] % 2 == 0){
                ans+=freq[i];
            }else{
                oddcount++;
                ans += freq[i]-1;
            }
        }
        if(oddcount > 0){
            ans++;
        }
        return ans;
    }
}