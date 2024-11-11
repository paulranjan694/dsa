class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length,maxProfit = -1;
        int[] dp = new int[n];
        dp[n-1] = prices[n-1];
        for(int i = n-2;i>=0;i--){
            dp[i] = Math.max(dp[i+1],prices[i]);
        }

        for(int i=0;i<n;i++){
            maxProfit = Math.max(maxProfit, (dp[i]-prices[i]));
        }
        return maxProfit;
    }
}