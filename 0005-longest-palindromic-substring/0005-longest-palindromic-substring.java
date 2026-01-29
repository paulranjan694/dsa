class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), maxLen=0, startIdx=0;
        char[] arr = s.toCharArray();
        String res="";
        boolean[][] dp = new boolean[n+1][n+1];

        for(int len=1;len<=n;len++){
            for(int i=0;i+len-1 < n;i++){
                int j = i+len-1;

                if(i==j){
                    dp[i][j] = true;
                }else if(i+1==j){
                    dp[i][j] = (arr[i]==arr[j]);
                }else{
                    dp[i][j] = (arr[i] == arr[j]) && dp[i+1][j-1];
                }

                if(dp[i][j]){
                    if(maxLen < len){
                        maxLen = len;
                        startIdx=i;
                    }
                }
            }
        }
        return s.substring(startIdx, startIdx+maxLen); 
    }
}