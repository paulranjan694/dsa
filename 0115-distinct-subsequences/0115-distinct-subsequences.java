class Solution {
    public int numDistinct(String s, String t) {
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