class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        //dp[0][0] = 1;

        for(String str : strs){
            int nZero = countZeros(str);
            int nOne = str.length() - nZero;
            for(int i=m;i>=nZero;i--){
                for(int j=n;j>=nOne;j--){
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-nZero][j-nOne]);
                }
            }
        }

        return dp[m][n];
    }

    private int countZeros(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                count++;
            }
        }
        return count;
    }
}