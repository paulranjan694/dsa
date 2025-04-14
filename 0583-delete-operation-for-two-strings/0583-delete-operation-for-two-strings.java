class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m=word2.length();
        int lcsLen =  lcs(word1,word2,n,m);
        return n+m-2*lcsLen;
    }
    
    private int lcs(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}