class Solution {
     public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(i-1 >=0) dp[i] = dp[i-1];
            if(i-2 >=0) dp[i] += dp[i-2];
        }
        return dp[n];

    }

    public int climbStairs2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return utils(n,dp);
    }

    private int utils(int n, int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n] != -1) return dp[n];
        return dp[n] = utils(n-1,dp) + utils(n-2,dp);
    }
}