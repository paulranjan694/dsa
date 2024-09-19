class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        //base case
        for(int i=0;i<=amount;i++){
            if(i%coins[0] ==0) dp[0][i] = 1;
            else dp[0][1] = 0;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notpick = dp[i-1][j];
                int pick = 0;
                if(j>=coins[i]) pick = dp[i][j-coins[i]];
                dp[i][j] = pick + notpick;
            }
        }
        return dp[n-1][amount];
    }

    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] ar:dp) Arrays.fill(ar,-1);
        return utils(amount,coins,n-1,dp);
    }

    private int utils(int amount, int[] coins, int idx, int[][] dp){
        if(idx==0){
            return amount % coins[0] == 0 ? 1 : 0;
        }
        int pick=0,notpick=0;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        if(amount>= coins[idx]) pick = utils(amount - coins[idx], coins,idx,dp);
        notpick = utils(amount, coins,idx-1,dp);
        dp[idx][amount] = pick + notpick;
        return pick + notpick;
    }
}