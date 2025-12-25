class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] d : dp){
            Arrays.fill(d,-1);
        }

        return utils(m,n,0,0,dp);
       
    }

    private int utils(int m, int n, int i, int j, int[][] dp){
        if(i==m-1 && j==n-1){
            return 1;
        }

        if(i>=m || j>=n) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = utils(m,n,i+1,j, dp) + utils(m,n,i,j+1, dp);
    }
}