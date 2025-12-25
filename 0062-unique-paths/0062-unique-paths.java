class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] d : dp){
            Arrays.fill(d,-1);
        }

        return utils(m,n,m-1,n-1,dp);
       
    }

    private int utils(int m, int n, int i, int j, int[][] dp){
        if(i==0 && j==0){
            return 1;
        }

        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = utils(m,n,i-1,j, dp) + utils(m,n,i,j-1, dp);
    }
}