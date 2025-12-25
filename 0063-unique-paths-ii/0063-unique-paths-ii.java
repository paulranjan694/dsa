class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        int n = mat.length,m=mat[0].length;
        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return utils(mat, n,m,n-1,m-1,dp);
    }

    private int utils(int[][] mat, int n, int m, int i, int j, int[][] dp){
        if(i==0 && j==0) {
            if(mat[i][j] == 1){
                return dp[i][j]=0;
            }else{
                return dp[i][j]=1;
            }
        }

        if(i<0 || j <0 ) {
            return 0;
        }

        if(mat[i][j] == 1) {
            return dp[i][j]=0;
        }


        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = utils(mat, n,m,i-1,j, dp) + utils(mat, n,m,i,j-1, dp);
    }
}