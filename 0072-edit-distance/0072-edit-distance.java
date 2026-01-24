class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            dp[i][0] = i;//1 based indexing
        }

        for(int j=1;j<m+1;j++){
            dp[0][j] = j;//1 based indexing
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insertOp = dp[i][j-1];
                    int deleteOp = dp[i-1][j];
                    int replaceOp = dp[i-1][j-1];
                    dp[i][j]= 1 + Math.min(insertOp, Math.min(deleteOp,replaceOp));
                }
            }
        }

        return dp[n][m];
    }

    private int utils(String s, String t, int i, int j){
        
        if(j<0) return i+1;
        if(i<0) return j+1;

        if(s.charAt(i) == t.charAt(j)){
            return utils(s,t,i-1,j-1);
        }

        int insertOp = utils(s,t,i,j-1);
        int deleteOp = utils(s,t,i-1,j);
        int replaceOp = utils(s,t,i-1,j-1);
        int minOp = 1 + Math.min(insertOp, Math.min(deleteOp,replaceOp));
        return minOp;
    }
}