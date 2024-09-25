class Solution {
    public int maxProfit(int[] prices) {
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
            profit = Math.max(-prices[day] + utils(prices,day+1,0,dp), utils(prices,day+1,1,dp));
        }else{
            profit = Math.max(prices[day] + utils(prices,day+1,1,dp), utils(prices,day+1,0,dp));
        }
        return dp[day][buy] = profit;
    }
}