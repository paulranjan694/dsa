class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return utils(0,0, prices,dp);
    }

    private int utils(int day, int buy, int[] prices, int[][] dp){
        if(day==prices.length) return 0;
        if(dp[day][buy] != -1) return dp[day][buy];
        int profit = 0;

        if(buy == 1){
            profit += Math.max((+prices[day]+utils(day+1,0,prices,dp)), utils(day+1,1,prices,dp));
        }else{
            profit += Math.max((-prices[day]+utils(day+1,1,prices,dp)), utils(day+1,0,prices,dp));
        }
        return dp[day][buy] = profit;
    }
}