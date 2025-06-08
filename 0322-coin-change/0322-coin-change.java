class Solution {
    private final int pow = (int)Math.pow(10,9);
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount==0) return 0;
        int[][] dp = new int[n+1][amount+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        int min = solve(coins,amount,n-1,dp);
        return min >= pow ? -1 : min;
    }

    private int solve(int[] coins, int amount, int idx, int[][] dp){
        if(idx==0){
            if(amount % coins[idx] == 0) return amount / coins[idx];
            else return pow;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int take = Integer.MAX_VALUE;
        if(amount-coins[idx] >= 0) take = 1 + solve(coins,amount-coins[idx],idx,dp);
        int nottake = solve(coins,amount,idx-1,dp);
        return dp[idx][amount] = Math.min(take, nottake);
    }
}