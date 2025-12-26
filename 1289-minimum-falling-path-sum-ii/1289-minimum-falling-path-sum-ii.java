class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length,m=mat[0].length;
        int[][]dp = new int[n][m];

        //base case
        for(int i=0;i<m;i++){
            dp[n-1][i] = mat[n-1][i];
        }

        for(int r = n-2;r>=0;r--){
            for(int last=0;last<m;last++){
                    int min=Integer.MAX_VALUE;
                for(int c=0;c<m;c++){
                    if(c == last) continue;
                    min = Math.min(min,dp[r+1][c]);
                }
                dp[r][last]=min + mat[r][last];
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            mini = Math.min(mini, dp[0][i]);
        }
        
        return mini;
    }
}
