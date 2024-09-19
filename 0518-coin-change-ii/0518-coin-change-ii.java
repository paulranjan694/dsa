class Solution {
    public int change(int amount, int[] coins) {
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