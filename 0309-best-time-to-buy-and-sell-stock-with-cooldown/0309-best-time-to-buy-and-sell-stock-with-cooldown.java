class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i=0;i<2;i++){
            for(int j= 1;j<3;j++){
                dp[n][i][j]=0;
            }
        }

        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                for(int cooldown=1;cooldown<3;cooldown++){
                    int profit = 0;
                    if(buy==0){
                        if(cooldown==1){
                            profit = Math.max(-prices[idx] + dp[idx+1][1][1], dp[idx+1][0][1]);
                        }else{
                            profit = Math.max(0, dp[idx+1][0][1]);
                        }
                    }else{
                        profit = Math.max(prices[idx] + dp[idx+1][0][2], dp[idx+1][1][1]);
                    }
                    dp[idx][buy][cooldown] = profit;
                }
            }
        }

        return dp[0][0][1];
    }

    private int solve(int[] prices, int idx, int buy, int cooldown){
        if(idx==prices.length) return 0;

        int profit = 0;
        if(buy==0){
            if(cooldown==1){
                profit = Math.max(-prices[idx] + solve(prices, idx+1, 1, 1), solve(prices, idx+1,0, 1));
            }else{
                profit = Math.max(0, solve(prices, idx+1,0, 1));
            }
        }else{
            profit = Math.max(prices[idx] + solve(prices, idx+1, 0, 2), solve(prices, idx+1,1, 1));
        }
        return profit;
    }
}