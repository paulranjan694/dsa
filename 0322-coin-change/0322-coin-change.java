class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        //base cond - amount > 0 and no coins left
        for(int a=1;a<=amount;a++){
            dp[n][a] = Integer.MAX_VALUE;
        }

        //base cond - amount = 0
        for(int i = 0;i<n+1;i++){
            dp[i][0] = 0;
        }

        for(int i = n-1;i>=0;i--){
            for(int a = 1;a<=amount;a++){
                int taken = Integer.MAX_VALUE;
                if(a >= coins[i]){
                    taken = dp[i][a-coins[i]];
                    if(taken != Integer.MAX_VALUE){
                        taken += 1;
                    }
                }
                
                int nottaken = dp[i+1][a];
                dp[i][a] = Math.min(taken, nottaken);
            }
        }

        return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
    }
}