class Solution {

    //Tabulation
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j] = 1;
                else{
                    int up=0, left=0;
                    if(i - 1 >= 0) up = dp[i-1][j];
                    if(j - 1 >= 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    /*
    //Memoization
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
    }*/
}