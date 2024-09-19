class Solution {
    public int findTargetSumWays(int[] arr, int d) {
        int totalSum=0;
        int n= arr.length;
        for(int e : arr) totalSum += e;
        int target = (totalSum - d);
        if(target < 0 || target % 2 != 0) return 0;
        target /= 2;
        int[][] dp = new int[n][target+1];
        
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        
        if(arr[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;
        
        if(arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int pick = 0;
                if(arr[i] <= j) pick = dp[i-1][j-arr[i]];
                int notPick = dp[i-1][j];
                dp[i][j] = pick + notPick;
            }
        }
        return dp[n-1][target];
    }
}