class Solution {

    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        //base case 
        for(int i=0;i<=n;i++) dp[i][0] = 1;//0th col
        for(int i=1;i<=m;i++) dp[0][i] = 0;//0th row

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }

    //memoization
    public int numDistinct2(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return utils(s,t,n,m,dp);
    }

    private int utils(String s, String t, int n, int m, int[][] dp){
        //base case
        if(m <= 0) return 1; //exhausted string t
        if(n<=0) return 0; // string s exhausted
        if(dp[n][m] != -1) return dp[n][m];
        if(s.charAt(n-1) == t.charAt(m-1)){
            return dp[n][m] = utils(s,t,n-1,m-1,dp) + utils(s,t,n-1,m,dp);
        }
        return dp[n][m] = utils(s,t,n-1,m,dp);
    }
}