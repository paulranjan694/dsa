class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        int n = mat.length,m=mat[0].length;
        int[][] dp = new int[n][m];

        if(mat[0][0] != 1){
            dp[0][0] = 1;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                   continue;
                }

                if(mat[i][j] != 1){
                    int left =0, up=0;

                    if(i-1 >= 0){
                        left = dp[i-1][j];
                    }

                    if(j-1 >= 0){
                        up = dp[i][j-1];
                    }

                    dp[i][j] = left + up;
                }
            }
        }

        return dp[n-1][m-1];
    }
}