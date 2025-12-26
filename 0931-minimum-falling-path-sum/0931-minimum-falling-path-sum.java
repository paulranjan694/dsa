class Solution {
    int neg = -1_00_000;
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length,m=mat[0].length, mini = Integer.MAX_VALUE;
        int[][]dp = new int[n][m];

        for(int[] d: dp){
            Arrays.fill(d,neg);
        }
        for(int i=0;i<mat[0].length;i++){
            mini = Math.min(mini, utils(mat,0,i, dp));
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