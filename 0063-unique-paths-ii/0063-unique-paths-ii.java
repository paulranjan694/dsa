class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],0);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int up=0,left=0;
                    if(i-1 >= 0) up = dp[i-1][j];
                    if(j - 1 >= 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n-1][m-1];
    }

    /*
    ******---Memoization---*******
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
    }*/
}