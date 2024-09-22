class Solution {
    
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] =  1 + dp[i-1][j-1];
                }else{
                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public int longestCommonSubsequence2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return utils(s1,s2,n-1,m-1,dp);
    }

    private int utils(String s1, String s2, int n, int m, int[][] dp){
        if(n<0 || m <0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(s1.charAt(n) == s2.charAt(m)){
            int match =  1 + utils(s1,s2,n-1,m-1,dp);
            return dp[n][m] = match;
        }
        int notMatch = Math.max(utils(s1,s2,n-1,m,dp),utils(s1,s2,n,m-1,dp));
        dp[n][m] = notMatch;
        return notMatch;
    }
}