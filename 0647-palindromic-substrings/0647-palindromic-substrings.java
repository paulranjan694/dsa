class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), count=0;
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[n+1][n+1];

        for(int len=1;len<=n;len++){
            for(int i=0;i+len-1 < n;i++){
                int j = i+len-1;

                if(i==j){
                    dp[i][j] = true;
                }else if(i+1==j){
                    dp[i][j] = (arr[i]==arr[j]);
                }else{
                    dp[i][j] = (arr[i] == arr[j]) && dp[i+1][j-1];
                }

                if(dp[i][j]){
                    count++;
                }
            }
        }
        return count;
        
    }

    private boolean check(char[] arr, int i, int j,Boolean[][]dp){
        if(i>=j) return true;
        if(dp[i][j] != null) return dp[i][j];
        if(arr[i]==arr[j]){
            return dp[i][j] = check(arr,i+1,j-1,dp);
        }
        return dp[i][j] = false;
    }
}