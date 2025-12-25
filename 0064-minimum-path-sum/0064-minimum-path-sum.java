class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) continue;

                int leftsum =Integer.MAX_VALUE,upsum=Integer.MAX_VALUE;
                if(i>0) leftsum = dp[i-1][j];
                if(j>0) upsum = dp[i][j-1];

                dp[i][j] = grid[i][j] + Math.min(leftsum, upsum);
            }
        }
        return dp[n-1][m-1];
    }
}