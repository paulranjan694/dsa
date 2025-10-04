class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];

        dp[n] = 0;
        for(int i = n-1;i>=0;i--){
            dp[i] = dp[i+1]; 
            if(i+2 <= n) dp[i] = Math.min(dp[i+2], dp[i]); 

            dp[i] += cost[i];
        }

        return Math.min(dp[0],dp[1]);
    }
}