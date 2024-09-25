class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        
        //base case
        dp[n][0] = dp[n][1] = 0;

        for(int day=n-1;day>=0;day--){
            for(int buy = 0;buy<2;buy++){
                if(buy==1){
                    dp[day][buy] = Math.max(-prices[day] + dp[day+1][0], dp[day+1][1]);
                }else{
                    dp[day][buy] = Math.max(prices[day] + dp[day+1][1], dp[day+1][0]);
                }
            }
        }
        return dp[0][1];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row:dp) Arrays.fill(row,-1);
        return utils(prices,0,1,dp);
    }

    private int utils(int[] prices, int day, int buy, int[][] dp){
        //base case
        if(day==prices.length) return 0;
        if(dp[day][buy] != -1) return dp[day][buy];
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[day] + utils(prices,day+1,0,dp)/*buy*/, utils(prices,day+1,1,dp)/**not buy */);
        }else{
            profit = Math.max(prices[day] + utils(prices,day+1,1,dp)/**sell */, utils(prices,day+1,0,dp)/**don't sell */);
        }
        return dp[day][buy] = profit;
    }
}