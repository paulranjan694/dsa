class Solution {
    int neg = -1_00_000;
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length,m=mat[0].length;
        int[][]dp = new int[n][m];

        //base case
        for(int i=0;i<m;i++){
            dp[n-1][i] = mat[n-1][i];
        }

        for(int r = n-2;r>=0;r--){
            for(int c=0;c<m;c++){
                int leftDia = Integer.MAX_VALUE, down=Integer.MAX_VALUE, rightDia=Integer.MAX_VALUE;

                if(c-1>=0){
                    leftDia = dp[r+1][c-1];
                }

                down = dp[r+1][c];

                if(c+1< m){
                    rightDia = dp[r+1][c+1];
                }

                int min = Math.min(leftDia, Math.min(down,rightDia));
   
                dp[r][c]=min + mat[r][c];
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            mini = Math.min(mini, dp[0][i]);
        }
        
        return mini;
    }

    private int utils(int[][] mat, int r, int c, int[][] dp){
        int n = mat.length,m=mat[0].length;

        if(r >= n || c < 0 || c >= m){
            return Integer.MAX_VALUE;
        }

        if(dp[r][c] != neg) return dp[r][c];
  
        if(r==n-1){
            return dp[r][c]=mat[r][c];
        }
    
        int leftDia = utils(mat,r+1, c-1,dp);
        int down = utils(mat, r+1,c,dp);
        int rightDia = utils(mat, r+1,c+1,dp);
        int mini = Math.min(leftDia, Math.min(down,rightDia));
   
        return dp[r][c]=mini + mat[r][c];
    }
}