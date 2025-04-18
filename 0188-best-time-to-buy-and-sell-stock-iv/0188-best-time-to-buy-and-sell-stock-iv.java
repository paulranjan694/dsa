class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int idx = n-1;idx >=0; idx--){
            for(int buy = 0;buy < 2;buy++){
                for(int cap = 1; cap<=k;cap++){
                    int profit=0;
                    if(buy==1){
                        profit = Math.max(-prices[idx] + dp[idx+1][0][cap], dp[idx+1][1][cap]);
                    }else{
                        profit = Math.max(prices[idx] + dp[idx+1][1][cap-1], dp[idx+1][0][cap]);
                    }
                    dp[idx][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][k];
    }
}