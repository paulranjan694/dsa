class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return utils(m-1,n-1,dp);
    }

    private int utils(int m ,int n, int[][] dp){
        //base cond
        if(m==0 && n==0){
            return dp[m][n] = 1;
        }

        if( m < 0 || n < 0) return 0;
        if(dp[m][n] != 0) return dp[m][n];
        int up = utils(m-1,n,dp);
        int left = utils(m,n-1,dp);
        dp[m][n] = up + left;

        return dp[m][n];
    }
}