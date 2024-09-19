class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] ar:dp) Arrays.fill(ar,-1);
        return utils(amount,coins,n-1,dp);
    }

    private int utils(int amount, int[] coins, int idx, int[][] dp){
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        int pick=0,notpick=0;
        if(idx>=0 && dp[idx][amount] != -1) return dp[idx][amount];
        if(idx>=0 && amount>= coins[idx]) pick = utils(amount - coins[idx], coins,idx,dp);
        if(idx>=0) notpick = utils(amount, coins,idx-1,dp);
        if(idx>=0) dp[idx][amount] = pick + notpick;
        return pick + notpick;
    }
}