class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n=text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }


    public int longestCommonSubsequence_momoized(String text1, String text2) {
        int m = text1.length(),n=text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        utils(text1,text2,m,n,dp);
        return dp[m][n];
    }

    private int utils(String x, String y, int m, int n, int[][] dp){
        //base cond
        if(m==0 | n==0){
            return 0;
        }

        //memoize lookup
        if(dp[m][n] != -1){
            return dp[m][n];
        }

        //recursive tree
        if(x.charAt(m-1)==y.charAt(n-1)){
            return dp[m][n] = 1 + utils(x,y,m-1,n-1,dp);
        }else{
            return dp[m][n] = Math.max(utils(x,y,m-1,n,dp),utils(x,y,m,n-1,dp));
        }

    }
}