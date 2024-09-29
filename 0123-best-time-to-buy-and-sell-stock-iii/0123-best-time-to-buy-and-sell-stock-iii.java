class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] arr : dp){
            for(int[] rw:arr){
                Arrays.fill(rw,-1);
            }
        }
        return utils(prices, 0,1,2,dp);
    }

    private int utils(int[] prices, int idx, int buy, int cap,int[][][] dp){

        //base case
        if(idx == prices.length || cap==0) return 0;
        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        int profit = 0;
        if(buy==1)
            profit = Math.max(-prices[idx] + utils(prices,idx+1,0,cap,dp), utils(prices, idx+1, 1,cap,dp));
        else
            profit = Math.max(prices[idx] + utils(prices,idx+1,1,cap-1,dp), utils(prices, idx+1, 0,cap,dp));

        return dp[idx][buy][cap] = profit;

    }
}