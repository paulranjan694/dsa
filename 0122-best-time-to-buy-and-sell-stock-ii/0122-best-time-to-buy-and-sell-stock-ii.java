class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        //base case
        dp[n][0]=dp[n][1] = 0;

        for(int day = n-1;day>=0;day--){
            for(int buy=0;buy<2;buy++){
                if(buy == 0){
                    dp[day][buy] =  Math.max(-prices[day]+dp[day+1][1], dp[day+1][0]);
                }else{
                    dp[day][buy] = Math.max(prices[day]+dp[day+1][0], dp[day+1][1]);
                }
            }
        }
        return dp[0][0];
    }

    private int solve(int[] prices, int idx,int buy){
        if(idx==prices.length) return 0;
        if(buy == 0){
            return Math.max(-prices[idx]+solve(prices, idx+1,1), solve(prices,idx+1,0));
        }else{
            return Math.max(prices[idx]+solve(prices, idx+1,0), solve(prices,idx+1,1));
        }
    }
}