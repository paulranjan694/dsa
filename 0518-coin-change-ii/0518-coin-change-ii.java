class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int a = 1;a<=amount;a++){
            if(a % coins[0] == 0) dp[0][a]=1;
        }

        for(int i=0;i<n;i++) dp[i][0] = 1;

        for(int i=1;i<n;i++){
            for(int a=1;a<=amount;a++){
                int taken=0;
                if(a - coins[i] >= 0){
                    taken = dp[i][a - coins[i]];
                }
                int notTaken = dp[i-1][a];

                dp[i][a] = taken+notTaken;
            }
        }

        return dp[n-1][amount];
    }


    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return solve(amount, coins, n-1, dp);
    }

    private int solve(int amount, int[] coins, int idx, int[][] dp){

        if(idx == 0){
            if(amount % coins[idx] == 0) return 1;
            return 0;
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int taken = 0;
        if(amount - coins[idx] >= 0){
            taken = solve(amount - coins[idx], coins,idx,dp);
        }

        int notTaken = solve(amount,coins,idx-1,dp);

        return dp[idx][amount] = taken + notTaken;
    }
}