class Solution {
    int n;
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        int[] dp = solve(cost);
        return Math.min(dp[0],dp[1]);
    }

    private int[] solve(int[] cost){
        int[] dp = new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            dp[i] = dp[i+1];
            if(i+2 <= n){
                dp[i] = Math.min(dp[i], dp[i+2]);
            } 
            dp[i] += cost[i];
        }
        return dp;
    }
}