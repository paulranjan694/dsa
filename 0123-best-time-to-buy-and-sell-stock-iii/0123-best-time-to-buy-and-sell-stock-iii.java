class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] ar : dp){
            for(int[] r : ar){
                Arrays.fill(r,-1);
            }
        }
        return solve(prices,0, 0, 2, dp);
    }

    private int solve(int[] prices, int idx, int buy, int k, int[][][] dp){
        if(idx==prices.length || k == 0) return 0;
        if(dp[idx][buy][k] != -1) return dp[idx][buy][k];
        int profit = 0;
        if(buy==0){
            profit = Math.max(-prices[idx] + solve(prices, idx+1, 1, k,dp), solve(prices, idx+1, 0,k,dp));
        }else{
            profit = Math.max(prices[idx] + solve(prices, idx+1, 0, k-1,dp), solve(prices, idx+1, 1,k,dp));
        }
        return dp[idx][buy][k] = profit;
    }
}