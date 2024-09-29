class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];

        for(int idx = n-1;idx>=0;idx--){
            for(int buy = 0; buy < 2;buy++){
                int profit=0;
                if(buy==1){
                    profit = Math.max(-prices[idx] + dp[idx+1][0], dp[idx+1][1]);
                }else{
                    profit = Math.max(prices[idx]-fee + dp[idx+1][1], dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }
}