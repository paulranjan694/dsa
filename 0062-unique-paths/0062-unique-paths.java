class Solution {
    public int uniquePaths(int m, int n) {
        int tempN = m+n-2;
        return nCr(tempN,m-1);
    }

    public int nCr(int n , int r){
        double ans = 1;
        for(int i = 1; i <= r; i++){
            ans*= (n-r+i);
            ans/=(i);
        }
        return (int)ans;
    }

    //tc - O(n^2)
    //sc - O(n^2)
    //dp - tabulation soln
    public int uniquePaths_dp(int m, int n) {
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

     //tc - O(n^2)
     //sc - O(n^2) + recursion stack space O(n^2)
     //dp - memo soln
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