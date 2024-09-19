class Solution {
    private final int pow = (int) Math.pow(10, 9);
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        //base case
        for(int T=0;T<=amount;T++){
            if(T % coins[0] == 0) dp[0][T] = T/coins[0];
            else dp[0][T] = pow;
        }

        for(int i=1;i<n;i++){
            for(int T=0;T<=amount;T++){
                int pick = Integer.MAX_VALUE;
                if(T >= coins[i]) pick = 1 + dp[i][T-coins[i]];
                int notPick = dp[i-1][T];
                dp[i][T] = Math.min(pick,notPick); 
            }
        }

        return dp[n-1][amount] >= pow ? -1 : dp[n-1][amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        int min = utils(coins,amount,n-1,dp);
        return min >= pow ? -1 : min;
    }

    private int utils(int[] coins, int amount,int idx, int[][] dp){
        if(idx==0){
            if(amount % coins[0] == 0) return amount/coins[0];
            else return pow;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int pick = Integer.MAX_VALUE;
        if(amount >= coins[idx]) pick = 1 + utils(coins, amount - coins[idx],idx,dp);
        int notPick = utils(coins, amount, idx-1,dp);
        dp[idx][amount] = Math.min(pick,notPick);
        return dp[idx][amount];
    }
}