class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(),m=str2.length();

        char[] ar1 = str1.toCharArray();
        char[] ar2 = str2.toCharArray();

        int[][] dp = lcs(ar1,ar2,n,m);

        StringBuilder sb = new StringBuilder();

        int i = n, j= m;
        while(i>0&&j>0){
            if(ar1[i-1]==ar2[j-1]){
                sb.append(ar1[i-1]);
                i--;
                j--;
            }else{
                if(dp[i][j-1] > dp[i-1][j]){
                    sb.append(ar2[j-1]);
                    j--;
                }else{
                    sb.append(ar1[i-1]);
                    i--;
                }
            }
        }

        while(i>0){
            sb.append(ar1[i-1]);
            i--;
        }

        while(j>0){
            sb.append(ar2[j-1]);
            j--;
        }

        return sb.reverse().toString();
    }

    private int[][] lcs(char[] ar1, char[] ar2, int n, int m){
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(ar1[i-1]==ar2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp;
    }
}