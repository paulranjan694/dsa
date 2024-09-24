class Solution {
    public int minDistance(String w1, String w2) {
        int n = w1.length(),m=w2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++) dp[i][0] = i;
        for(int j=1;j<=m;j++) dp[0][j] = j;
        //dp[0][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(w1.charAt(i-1)==w2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insertop = dp[i][j-1];
                    int deleteop = dp[i-1][j];
                    int replaceop = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(insertop, Math.min(deleteop, replaceop));
                }

            }
        }

        return dp[n][m];
        
    }

    public int minDistance2(String w1, String w2) {
        int n = w1.length(),m=w2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);
        return utils(w1,w2,n-1,m-1,dp);
    }

    private int utils(String w1, String w2, int i, int j, int[][] dp){
        //base case
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)){
            return dp[i][j] = utils(w1,w2,i-1,j-1,dp);
        }

        int insertop = utils(w1,w2,i,j-1,dp);
        int deleteop = utils(w1,w2,i-1,j,dp);
        int replaceop = utils(w1,w2,i-1,j-1,dp);
        return dp[i][j] = 1 + Math.min(insertop, Math.min(deleteop, replaceop));
    }
}