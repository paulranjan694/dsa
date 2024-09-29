class Solution {

    public int maxProfit(int[] prices) {
        int n =prices.length;
        int[][][] dp = new int[n+1][2][3];
        //base case
        //1. cap==0
        for(int i = 0;i <= n;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0] = 0;
            }
        }
        //2. index==0
        for(int j=0;j<2;j++){
            for( int k = 0; k<3;k++){
                dp[n][j][k] = 0;
            }
        }

        for(int idx = n-1;idx>=0;idx--){
            for(int buy = 0; buy < 2; buy++){
                for(int cap=1;cap<3;cap++){
                    int profit = 0;
                    if(buy==1)
                        profit = Math.max(-prices[idx] + dp[idx+1][0][cap], dp[idx+1][1][cap]);
                    else
                        profit = Math.max(prices[idx] + dp[idx+1][1][cap-1], dp[idx+1][0][cap]);

                    dp[idx][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];


       
    }

    public int maxProfit2(int[] prices) {
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