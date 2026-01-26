class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int i=0;i<=n;i++){
            for(int buy=0;buy<2;buy++){
                dp[i][buy][0] = 0;
            }
        }

        for(int buy=0;buy<2;buy++){
            for(int i = 0;i<k;i++){
                dp[n][buy][i]=0;
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int t =1;t<=k;t++){
                    int profit = 0;
                    if(buy==0){
                        profit = Math.max(-prices[i] + dp[i+1][1][t], dp[i+1][0][t]);
                    }else{
                        profit = Math.max(prices[i] + dp[i+1][0][t-1], dp[i+1][1][t]);
                    }
                    dp[i][buy][t] = profit;
                }
            }
        }
        
        return dp[0][0][k];
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