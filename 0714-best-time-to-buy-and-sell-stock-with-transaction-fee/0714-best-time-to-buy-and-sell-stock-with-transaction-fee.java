class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int i=0;i<2;i++){
            dp[n][i]=0;
        }

        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                for(int cooldown=1;cooldown<3;cooldown++){
                    int profit = 0;
                    if(buy==0){
                        profit = Math.max(-prices[idx] + dp[idx+1][1], dp[idx+1][0]);
                    }else{
                        profit = Math.max(prices[idx] + dp[idx+1][0] - fee, dp[idx+1][1]);
                    }
                    dp[idx][buy] = profit;
                }
            }
        }

        return dp[0][0];
    }
}