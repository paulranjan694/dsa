class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        
        //base case
        dp[n][0] = dp[n][1] = 0;

        for(int day=n-1;day>=0;day--){
            for(int buy = 0;buy<2;buy++){
                if(buy==1){
                    dp[day][buy] = Math.max(-prices[day] + dp[day+1][0], dp[day+1][1]);
                }else{
                    dp[day][buy] = Math.max(prices[day] + dp[day+2][1], dp[day+1][0]);
                }
            }
        }
        return dp[0][1];
    }

}