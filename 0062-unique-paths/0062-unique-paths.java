class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return utils(0,0,m,n,dp);
    }

    public int utils(int r,int c, int m ,int n,int[][] dp){
        //base case
        if(r==m-1 && c==n-1){
            return 1;
        }
        if(r >= m || c >= n){
            return 0;
        }
        int res = 0;
        if(dp[r][c] != -1) return dp[r][c];
        res += utils(r,c+1,m,n,dp);
        res += utils(r+1,c,m,n,dp);
        return dp[r][c] = res;
    }
}