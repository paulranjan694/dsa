class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1+2][l2+2];
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        return dp[l1][l2];
    }

    private int utils(String text1, String text2, int i, int j, int[][] dp){
        if(i<0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = utils(text1, text2, i-1, j-1,dp) + 1;
        }

        return dp[i][j]=Math.max(utils(text1, text2, i-1, j,dp), utils(text1, text2, i, j-1,dp));
    }
}