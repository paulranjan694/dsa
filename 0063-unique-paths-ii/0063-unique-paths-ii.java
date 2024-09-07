class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return utils(obstacleGrid,n-1,m-1,dp);
    }

    private int utils(int[][] grid, int n, int m, int[][] dp){
        if(n==0 && m == 0 && grid[n][m] != 1) {
            dp[n][m] = 1;
            return 1;
        }

        if(n < 0 || m < 0 || grid[n][m] == 1) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        int up = utils(grid,n-1,m, dp);
        int left = utils(grid, n, m-1, dp);
        dp[n][m] = up + left;

        return dp[n][m];
    }
}