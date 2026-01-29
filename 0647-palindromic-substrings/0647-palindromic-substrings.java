class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), count=0;
        char[] arr = s.toCharArray();
        Boolean[][] dp = new Boolean[n+1][n+1];


        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(check(arr,i,j, dp)){
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