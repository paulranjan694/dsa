class Solution {
    static int pow = (int) Math.pow(10, 9);
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n+1][amount+1];

        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i],-1);
        // }

        for(int i=0;i<=amount;i++){
            if(i%coins[0] ==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i] = pow;
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount]==pow?-1:dp[n][amount];
    }
}