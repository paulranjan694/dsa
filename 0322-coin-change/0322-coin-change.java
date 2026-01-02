class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];

        //base
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[i] = i/coins[0];
            }else{
                dp[i] = amount+1;
            }
        }

        for(int i=1;i<n;i++){
             int[] prev= new int[amount+1];
            for(int a=0;a<=amount;a++){
                int take = Integer.MAX_VALUE;
                if(coins[i] <= a){
                    take = prev[a - coins[i]] + 1;
                }

                int notTake = dp[a];

                prev[a] = Math.min(take,notTake);
            }
            dp = prev;
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    private int utils(int[] coins, int amount, int idx){
        //base
        if(idx==0){
            if(amount % coins[0] == 0){
                return amount/coins[0];
            }
            return -1;
        }

        int take = Integer.MAX_VALUE;
        if(amount - coins[idx] >= 0){
            take = utils(coins, amount - coins[idx], idx) + 1;
        }

        int notTake = utils(coins, amount, idx-1);

        return Math.min(take,notTake);
    }
}