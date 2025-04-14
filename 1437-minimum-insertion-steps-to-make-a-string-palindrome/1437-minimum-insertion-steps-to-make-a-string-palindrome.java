class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String revS = new StringBuilder(s).reverse().toString();
        int lcsLen =  lcs(s,revS,n,n);
        return n-lcsLen;
    }

    public int lcs(String s1,String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }

}