class Solution {

     public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];

        //base case
        dp[m-1][n-1]=1;

        for(int r = m-1;r>=0;r--){
            for(int c = n-1;c>=0;c--){
                if(r == m-1 && c==n-1) continue;
                int temp=0;
                temp+= dp[r][c+1];
                temp+= dp[r+1][c];
                dp[r][c] = temp;
            }
        }
        return dp[0][0];
     }

    public int uniquePaths2(int m, int n) {
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