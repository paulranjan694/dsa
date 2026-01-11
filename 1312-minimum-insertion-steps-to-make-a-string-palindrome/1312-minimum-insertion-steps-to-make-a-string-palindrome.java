class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        return n-lcs(s,rev);
    }

    private int lcs(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];

        char[] a1 = text1.toCharArray();
        char[] a2 = text2.toCharArray();
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(a1[i-1] == a2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        return dp[l1][l2];
    }
}