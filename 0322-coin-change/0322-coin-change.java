class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount+1][coins.length+1];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        int min = utils(coins, amount, 0, dp);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int utils(int[] coins, int amount, int index, int[][] dp){
        //base condition

        if(index >= coins.length){
            if(amount > 0){
                return Integer.MAX_VALUE;
            }
            return 0;
        }

        if(dp[amount][index] != -1) return dp[amount][index];

        int taken = Integer.MAX_VALUE;
        if(amount >= coins[index]){
            taken = utils(coins, amount-coins[index], index, dp);
            if(taken != Integer.MAX_VALUE) 
                taken += 1;
        }

        int notTaken = utils(coins, amount, index+1,dp);
        return dp[amount][index] = Math.min(taken, notTaken);
    }
}