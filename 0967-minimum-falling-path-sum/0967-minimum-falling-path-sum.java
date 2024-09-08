class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        for(int i=0;i<n;i++){
            dp[n-1][i] = matrix[n-1][i];
        }

        for(int i = n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int min = Integer.MAX_VALUE;
                min = Math.min(min, dp[i+1][j]);
                if(j+1 < n) min = Math.min(min, dp[i+1][j+1]);
                if(j-1 >= 0)  min = Math.min(min, dp[i+1][j-1]);
                min += matrix[i][j];
                dp[i][j] = min;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,dp[0][i]);
        }
        return min;
    }

    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        int min = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            int maxsum = utils(matrix, 0,i,dp);
            min = Math.min(min,maxsum);
        }
        return min;
    }

    private int utils(int[][] matrix, int r, int c, int[][] dp){
        //base cond
        int n = matrix.length;
        if( c < 0 || c == n) return Integer.MAX_VALUE;

        if(r==n-1){
            //dp[r][c] = matrix[r][c];
            return matrix[r][c];
        }

        if(dp[r][c] != -1) return dp[r][c];

        int min = Integer.MAX_VALUE;

        min = Math.min(min, utils(matrix, r+1, c, dp));
        min = Math.min(min, utils(matrix, r+1, c+1, dp));
        min = Math.min(min, utils(matrix,r+1,c-1, dp));
        
        min += matrix[r][c];
        dp[r][c] = min;
        return dp[r][c];
    }
}