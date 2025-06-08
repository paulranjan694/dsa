class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int n2 = 0;
            if(i+2 < n+1) n2 = dp[i+2];
           dp[i] = cost[i] + Math.min(dp[i+1],n2);
        }
        return Math.min(dp[0],dp[1]);
    }
}